package optional;

import stream.Author;

import java.util.Optional;

/**
 * @author Kui Lian
 * @date 2022/8/15 - 14:39
 * @Description:
 */
public class OptionalDemo {
    public static void main(String[] args) {


    }
    public static Optional<Author> getAuthor()
    {
        //数据初始化
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        return Optional.ofNullable(author);
    }
}
