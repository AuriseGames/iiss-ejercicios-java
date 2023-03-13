# Práctica 1: Herencia, composición y polimorfismo

## Ejercicios propuestos

### Ejercicio 1

Dados los siguientes fragmentos de código, responder a las siguientes preguntas:

#### `ElementsSet.java`

```java
public class ElementsSet<E> extends HashSet<E> {
    //Number of attempted elements insertions using the "add" method
    private int numberOfAddedElements = 0;

    public ElementsSet() {}

    @Override
    public boolean add(E element) {
        numberOfAddedElements++; //Counting the element added
        return super.add(element);
    } 

    @Override
    public boolean addAll(Collection<? extends E> elements) {
        numberOfAddedElements += elements.size(); //Counting the elements added
        return super.addAll(elements);
    } 

    public int getNumberOfAddedElements() {
        return numberOfAddedElements;
    }
}
```

#### `Main.java`

```java
    ...
    ElementsSet<String> set = new ElementsSet<String>();
    set.addAll(Arrays.asList("One", "Two", "Three"));
    System.out.println(set.getNumberOfAddedElements());
    ...
```

#### Preguntas propuestas

a) ¿Es el uso de la herencia adecuado para la implementación de la clase `ElementsSet`? ¿Qué salida muestra la función `System.out.println` al invocar el método `getNumberOfAddedElements`, 3 o 6?

    El resultado de la operación imprimiría en pantalla el valor 6 en lugar de 3 debido a que la clase ElementsSet<E> extiende la clase HashSet<E> y sobrescribe los métodos add y addAll. Sin embargo, los métodos addAll de HashSet también invocan el método add para insertar cada elemento en el conjunto.

    Por lo tanto, cuando se llama al método addAll de ElementsSet<E> con una colección de tres elementos, el método addAll sobrescrito de ElementsSet<E> cuenta los tres elementos agregados, pero también llama al método add sobrescrito de ElementsSet<E> tres veces para agregar cada elemento individualmente, lo que también incrementa la variable numberOfAddedElements.

    Por lo tanto, la variable numberOfAddedElements termina con un valor de 6 en lugar de 3. Esto demuestra un mal uso de la herencia, ya que la implementación de la superclase puede tener efectos secundarios no deseados en la subclase.

b) En el caso de que haya algún problema en la implementación anterior, proponga una solución alternativa usando composición/delegación que resuelva el problema.

    Una solución alternativa usando composición/delegación podría ser crear una instancia privada de HashSet<E> dentro de la clase ElementsSet<E> y delegar la implementación de los métodos add y addAll a esa instancia. De esta manera, se evitaría la herencia de la clase HashSet<E> y se tendría un mayor control sobre la implementación de los métodos.

    El código de la solución alternativa quedaría de la siguiente manera:

#### `ElementsSet.java`

```java
public class ElementsSet<E> {
    //Number of attempted elements insertions using the "add" method
    private int numberOfAddedElements = 0;
    private HashSet<E> set;

    public ElementsSet() {
        set = new HashSet<E>();
    }

    public boolean add(E element) {
        numberOfAddedElements++; //Counting the element added
        return set.add(element);
    } 

    public boolean addAll(Collection<? extends E> elements) {
        numberOfAddedElements += elements.size(); //Counting the elements added
        return set.addAll(elements);
    } 

    public int getNumberOfAddedElements() {
        return numberOfAddedElements;
    }
}
```

    Con esta implementación, se asegura que el método addAll no llame al método add de la superclase HashSet<E>, evitando así la duplicación en la cuenta de elementos agregados. Al mismo tiempo, se mantiene la funcionalidad de la clase original y se tiene un mayor control sobre la implementación de los métodos.

### Ejercicio 2

Dado los siguientes fragmentos de código responder a las siguientes preguntas:

#### `Animal.java`

```java
public abstract class Animal {
    //Number of legs the animal holds
    protected int numberOfLegs = 0;

    public abstract String speak();
    public abstract boolean eat(String typeOfFeed);
    public abstract int getNumberOfLegs();
}
```

#### `Cat.java`

```java
public class Cat extends Animal {
    @Override
    public String speak() {
        return "Meow";
    }

    @Override
    public boolean eat(String typeOfFeed) {
        if(typeOfFeed.equals("fish")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getNumberOfLegs() {
        return super.numberOfLegs;
    }
}
```

#### `Dog.java`

```java
public class Dog extends Animal {
    @Override
    public String speak() {
        return "Woof";
    }

    @Override
    public boolean eat(String typeOfFeed) {
        if(typeOfFeed.equals("meat")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getNumberOfLegs() {
        return super.numberOfLegs;
    }
}
```

#### `Main.java`

```java
    ...
    Animal cat = new Cat();
    Animal dog = new Dog();
    System.out.println(cat.speak());
    System.out.println(dog.speak());
    ...
```

#### Preguntas propuestas

a) ¿Es correcto el uso de herencia en la implementación de las clases `Cat` y `Dog`? ¿Qué beneficios se obtienen?

    No es correcto el uso de herencia en la implementación de las clases Cat y Dog ya que las clases derivadas no están especializando el comportamiento de la clase base, es decir, no están agregando nuevas funcionalidades a las que ya existen en la clase Animal. En cambio, simplemente están redefiniendo los métodos ya existentes en la clase base. Este enfoque no cumple con el principio de sustitución de Liskov, que establece que las instancias de una clase derivada deben poder utilizarse en lugar de las instancias de la clase base sin afectar el comportamiento del programa.

b) En el caso de que el uso de la herencia no sea correcto, proponga una solución alternativa. ¿Cuáles son los beneficios de la solución propuesta frente a la original?

    Una solución alternativa sería utilizar la composición en lugar de la herencia. En lugar de hacer que Cat y Dog hereden de Animal, se podrían crear objetos Animal dentro de las clases Cat y Dog. De esta manera, se podrían utilizar las funcionalidades de Animal sin heredar su implementación y, por lo tanto, evitar la violación del principio de sustitución de Liskov.

    Por ejemplo:

#### `Animal.java`

```java
public abstract class Animal {
    //Number of legs the animal holds
    protected int numberOfLegs = 0;

    public abstract String speak();
    public abstract boolean eat(String typeOfFeed);
    public abstract int getNumberOfLegs();
}
```

#### `Cat.java`

```java
public class Cat {
    private Animal animal = new Animal();

    public String speak() {
        return "Meow";
    }

    public boolean eat(String typeOfFeed) {
        if(typeOfFeed.equals("fish")) {
            return true;
        } else {
            return false;
        }
    }

    public int getNumberOfLegs() {
        return animal.getNumberOfLegs();
    }
}
```
#### `Dog.java`

```java
public class Dog {
    private Animal animal = new Animal();

    public String speak() {
        return "Woof";
    }

    public boolean eat(String typeOfFeed) {
        if(typeOfFeed.equals("meat")) {
            return true;
        } else {
            return false;
        }
    }

    public int getNumberOfLegs() {
        return animal.getNumberOfLegs();
    }
}
```