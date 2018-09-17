package Generics;

import Pet.Animal;
import Pet.Dog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericLists {

    public static void main(){
        //ArrayList<Dog> dogs1 = new ArrayList<Animal>();//обобщения разных типов ровнять не хочет
        //ArrayList<Animal> animals1 = new ArrayList<Dog>();//обобщения разных типов ровнять не хочет
        List<Animal> list = new ArrayList<Animal>();
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        //ArrayList<Animal> animals = dogs; //обобщения разных типов ровнять не хочет
        List<Dog> dogList = dogs;
        ArrayList<Object> objects = new ArrayList<Object>();
        List<Object> objectList = objects;
        //ArrayList<Object> objs = new ArrayList<Dog>();//разные типы!!

    }

}
