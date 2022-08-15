package stream;

import java.util.*;

/**
 * @author Kui Lian
 * @date 2022/8/14 - 14:05
 * @Description:
 */
public class StreamDemo {
    public static void main(String[] args) {


        test09();
    }

    private static void test09() {

    }

    private static void test08() {
        getAuthors()
                .stream()

                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(au-> System.out.println(au));
    }

    private static void test07() {
        getAuthors().stream()
                .distinct()
                .sorted(((o1, o2) -> o2.getAge()-o1.getAge()))
                .skip(1)
                .forEach(author -> System.out.println(author.getAge()));
    }

    private static void test06() {
        getAuthors().stream()
                .sorted(((o1, o2) -> o2.getAge()-o1.getAge()) )
                .limit(2).forEach(author -> System.out.println(author.getAge()));
    }

    private static void test05() {
        getAuthors().stream()
                .distinct()
                .sorted(new Comparator<Author>() {
                    @Override
                    public int compare(Author o1, Author o2) {
                        return o2.getAge()-o1.getAge();
                    }
                }).forEach(author -> System.out.println(author.getAge()));
    }

    private static void test04() {
        getAuthors().stream()
                .distinct()
                .map(author -> author.getAge()+100)
                .forEach(aut-> System.out.println(aut));
    }

    private static void test03() {
        getAuthors()
                .stream()
                .distinct()
                .filter(author -> author.getName().length()>1)
                .forEach(author -> System.out.println(author));

    }

    private static void test02() {
        Map<String,Integer> map = new HashMap<>();
        map.put("蜡笔小新",19);
        map.put("黑子",17);
        map.put("日向翔阳",16);

        map.entrySet().stream().filter(entry -> entry.getValue() > 18)
                .forEach(e -> System.out.println(e));
    }

    private static void test01(List<Author> authors) {
        authors.stream()
                .distinct().filter(author -> author.getAge()<18)
                .forEach(author -> System.out.println(author));
        System.out.println("---------------------------");
        for (Author author : authors) {
            System.out.println(author);
        }
    }

    private static List<Author> getAuthors() {
        //数据初始化
        Author author = new Author(1L,"蒙多",33,"一个从菜刀中明悟哲理的祖安人",null);
        Author author2 = new Author(2L,"亚拉索",15,"狂风也追逐不上他的思考速度",null);
        Author author3 = new Author(3L,"易",14,"是这个世界在限制他的思维",null);
        Author author4 = new Author(3L,"易",14,"是这个世界在限制他的思维",null);

        //书籍列表
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L,"刀的两侧是光明与黑暗","哲学,爱情",88,"用一把刀划分了爱恨"));
        books1.add(new Book(2L,"一个人不能死在同一把刀下","个人成长,爱情",99,"讲述如何从失败中明悟真理"));

        books2.add(new Book(3L,"那风吹不到的地方","哲学",85,"带你用思维去领略世界的尽头"));
        books2.add(new Book(3L,"那风吹不到的地方","哲学",85,"带你用思维去领略世界的尽头"));
        books2.add(new Book(4L,"吹或不吹","爱情,个人传记",56,"一个哲学家的恋爱观注定很难把他所在的时代理解"));

        books3.add(new Book(5L,"你的剑就是我的剑","爱情",56,"无法想象一个武者能对他的伴侣这么的宽容"));
        books3.add(new Book(6L,"风与剑","个人传记",100,"两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));
        books3.add(new Book(6L,"风与剑","个人传记",100,"两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));

        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author,author2,author3,author4));
        return authorList;
    }
}
