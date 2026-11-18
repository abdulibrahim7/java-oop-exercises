# Java Object-Oriented Programming Exercises

A CS3650 coursework collection demonstrating inheritance through employee classes, interfaces through payable records, polymorphism through ship types, aggregation through courses, and composition through a file-and-folder model.

## Build and run

Use JDK 17. Compile all examples and run a driver from the repository root.

```sh
mkdir -p out
javac --release 17 -d out $(find src -name '*.java')
java -cp out problem1.InheritanceDriver
java -cp out problem5.CompositionDriver
```

Each package contains a standalone coursework example. The drivers print sample results to the console.
