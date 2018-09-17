package StrangeExample;

public class EqualsOrequals {

    /*


    ВЫВОД: сравнение объектов необходимо осуществлять с помощью equals


    int вмещает значения от -127 до 128

    запредельные значения int можно сравнивать с помощью ==
    любые значения примитивов можно сравнивать с помощью ==
    потому что equals - это метод объекта и к примитиву он не применим

    однако

    при сравнении запредельных значений объектов Integer с помощью == мы получим ошибку!!!
    так как если к объектам применяется == , то сравниваются не сами объекты а их ссылки, то есть возвращается true если ссылки ведут на один и тот же объект
    но в случае Integer a=200;



     */


    public static void main(String[] args) {

        //для разминки сравним строки
        System.out.println("********1");
        String s1 = "1000";
        String s2 = "1000";

        if (s1 == s2){
            System.out.println("s1 = s2");
        } else {
            System.out.println("s1 != s2");
        }
        //s1 = s2   потому что в памяти хранится один литерал "1000" и обе ссылки ссылаются на него
        System.out.println("********");
        //с числами будет поинтереснее!!!




        System.out.println("********2");
        //попробуем сравнить с помощью == два объекта Integer
        //интересно, что первый пример выдает false!
        Integer i = 200;
        Integer j = 200;
        if(i == j){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        //а следующий выдает true!
        Integer i2 = 100;
        Integer j2 = 100;
        if(i2 == j2){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        /*false true  потому что, мы сравниваем ссылки, когда применяем == к объектам, и первый случай отличается от второго тем,
         что в java УЖЕ ЕСТЬ заготовленные объекты от -128 до 127 для Integer, и когда мы сравниваем ссылки, то ссылки указывают на один и тот же зарезервированнный объект из этого пула заготовок,
          перед сравнением производится следующая операция(которая кстати производится при любой распаковке-упаковке)*/
        Integer b2 = Integer.valueOf(100);
        /*
        если мы залезем внутрь valueOf()
        мы увидим, что в случае, когда мы присваиваем Integer значение которое не входит в его пределы, возвращается значение из кеша IntegerCache.cache[i + 128] (см исходный код java 1.6, строка 621)
        */

        /*
        public static Integer valueOf(int i) {
        if(i >= -128 && i <= IntegerCache.high)
            return IntegerCache.cache[i + 128];
        else
        return new Integer(i);
        }
        */

        /*
        Как видим тут есть некоторое значение high, которое кстати можно задать...
        high может быть настроено на другое значение с системным свойством.
        -Djava.lang.Integer.IntegerCache.high = 999

        Но самое главное для нас тут в том, что мы получаем false - две разные ссылки на два разных объекта
         */
        System.out.println("********");




        System.out.println("********3");
        //Но если мы будем использовать для сравнения equals - мы избавимся от этих проблем!
            Integer a=200;
            Integer b=200;
            Integer c=20;
            Integer d=20;

            System.out.println(a==b);
            System.out.println(a.equals(b));
            System.out.println(c==d);
            System.out.println(c.equals(d));
            /*
            ********
            false
            true
            true
            true

            equals отработал отлично, что не скажешь про ==
             */
        System.out.println("********");




        System.out.println("********4");
        //но помним, что с int-ами мы такого не проделаем
        int a3=200;
        int b3=200;
        int c3=20;
        int d3=20;

        System.out.println(a3==b3);
        //System.out.println(a2.equals(b2));//компилятор выдает ошибку! - int - не объект а примитивный тип!
        System.out.println(c3==d3);
        //System.out.println(c2.equals(d2));//компилятор выдает ошибку! - int - не объект а примитивный тип!
        /*
        ********
            true
            true
         */
        System.out.println("********");




        System.out.println("********5");
        //а если захотим сделать так?
        int i3 = 5;
        Integer j3 = 5;
        //можно ли сравнить i == j ?
        //то есть, возможна ли такая конструкция?
        if (i == j){System.out.println("i ==j");}else{System.out.println("i !=j");}
        //нет! ссылки
        System.out.println("********");
    }

}
