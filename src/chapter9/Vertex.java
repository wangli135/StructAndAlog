package chapter9;

/**
 * 图的顶点类
 * Created by Xingfeng on 2016-11-19.
 */
public class Vertex {

    public char label;
    public boolean visited;

    public Vertex(char label) {
        this.label = label;
        visited = false;
    }
}
