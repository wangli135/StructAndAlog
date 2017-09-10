package pinduoduo;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangl on 2017/7/14.
 */
public class ImageLoader {

    private static volatile ImageLoader INSTANCE = null;

    private Set<String> processUrls = Collections.synchronizedSet(new HashSet<>());

    //记录重复的URL后的回调
    private Map<String, ArrayList<ImageCallback>> repeatUrlRequest = Collections.synchronizedMap(new HashMap<>());

    private static final int CPU_COUNT = Runtime.getRuntime()
            .availableProcessors();
    private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
    private static final long KEEP_ALIVE = 10L;

    private ThreadPoolExecutor executor = new ThreadPoolExecutor(
            CORE_POOL_SIZE, MAXIMUM_POOL_SIZE,
            KEEP_ALIVE, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(128));

    private ImageLoader() {
    }

    public static ImageLoader getInstance() {
        if (INSTANCE == null) {
            synchronized (ImageLoader.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ImageLoader();
                }
            }
        }
        return INSTANCE;
    }


    public void loadImage(String url, ImageCallback callback) {

        //首先从缓存中获取
        Image image = ImageCache.loadImage(url);
        //图片不为空，直接处理和返回
        if (image != null) {
            callback.call(image);
            return;
        }

        //图片为空，进行网络请求
        //如果该URL没有正在进行网络操作，那么进行网络操作
        if (!processUrls.contains(url)) {

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    Network.loadImage(url, new ImageCallback() {
                        @Override
                        public void call(Image image) {
                            //存入缓存
                            ImageCache.saveImage(url, image);
                            if (callback != null) {
                                callback.call(image);
                            }
                            processUrls.remove(url);
                            //处理重复URL的回调
                            ArrayList<ImageCallback> repeatImageCallbackList = repeatUrlRequest.get(url);
                            if (repeatImageCallbackList == null) {
                                synchronized (ImageLoader.class) {
                                    repeatImageCallbackList = repeatUrlRequest.get(url);
                                    if (repeatImageCallbackList == null) {
                                        return;
                                    }

                                }
                            }

                            //如果不为空，对列表加锁
                            synchronized (repeatImageCallbackList) {
                                for (ImageCallback ic : repeatImageCallbackList)
                                    ic.call(image);
                            }

                            repeatUrlRequest.remove(url);


                        }
                    });
                }
            });

        } else {

            ArrayList<ImageCallback> repeatImageCallbackList = repeatUrlRequest.get(url);
            if (repeatImageCallbackList == null) {
                synchronized (ImageLoader.class) {
                    repeatImageCallbackList = repeatUrlRequest.get(url);
                    if (repeatImageCallbackList == null) {
                        repeatImageCallbackList = new ArrayList<>();
                        repeatUrlRequest.put(url, repeatImageCallbackList);
                    }

                }
            }
            repeatImageCallbackList.add(callback);

        }


    }


}
