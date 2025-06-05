 # Project file manipulation

This program can read a file, perform some manipulations on its data, and save the result to a new file.

The program takes three parameters: file1 file2 method  
``` 
    file1  - the input file to read and manipulate  
    file2  - the output file where the manipulated result will be written  
    method - the name of the manipulation method to execute
```

Currently, the program supports two types of manipulation:

```
    reverse - reverses the order of lines in the file  
    sort    - sorts the lines in alphabetical order
```

To add new functionality (i.e., a new type of manipulation),  
you need to implement a new method in the FileManipulationMethods class.

If the program is run with a method that is not defined in FileManipulationMethods,  
it will print an error message to the console.




