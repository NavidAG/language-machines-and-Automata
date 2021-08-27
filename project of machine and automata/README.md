# Antler

This projects aimes to introduce a few concepts regarding Antler language and Understanding the language trees by asking for a pseudo language implementation. 



### Language Structure
1. In the beginning, There must be one or many libraries or their components.
2. Each program could have one or many classes.
3. Each class includes some variables and functions.
4. After each command, there must be a semicolon (';').
5. Naming scheme shall be similar to Java but every name must have at least two characters.

* library implementation syntax and global variables
```
func1 = from <library-2> require <function1>;
lib1 = require <library-1>; 
...
```

* Class implementation
`extends` and `implements` components are optional.
```
class <class-Name> extends <parent-class-name> implements <interface-name-1>, <interface-name2>, ... {
      <statement-1>
      <statement-2>
...      
}
```

* Variables
```
let/const <variable-type> <variable-name>, <variable-name> (= <value>), ...;
let/const <variable-type> <variable-name> = <variable-name> = ... = <value>;
let/const <variable-type>[] <variable-name>, <variable-name> (= <value>), ...;
let/const <variable-type>[] <variable-name> = <variable-name> = ... = <value>;
```

* This pseudo language features `int`, `fload`, constants like `true`, `false` and `null`.
* Function and method implantation 
```
<func-name> = (<func-args>) => { 
  <function-Code>
  return <value> | <variable-name (Optional)
}
```

* Loops implementation 
```
for (<variable-name> in <variable-range> step <int>) { 
  <function-code>
}
```
or
```
for (auto <variable-name> in <iterator-name>) { 
  <function-code>
}
```

* Conditional statements shall be implemented like Java.
* Operators:
```
% ,// ,/ ,** ,* ,- ,+

=// ,=**,=% ,=/ ,=*,=- ,=+ , =

& ,| ,^ ,~ ,<< ,>>
```
* Operators Priorities
```
1. ()
2. **
3. ~
4. - +
5. * / // %
6. - +
7. ###
8. >> <<
9. & ^ |
10. == != <>
11. < <= > >=
12. = **= /= //= *= &= -= +-
13. not and or
```
