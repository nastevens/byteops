ByteOps
=======

Java library (one class actually) for manipulating native bytes without the
associated casting and shifting headaches.

Why?
====
Working with bytes in Java sucks. The biggest problem is that there is no easy
way to represent raw unsigned bytes in a form that makes sense to the typical
embedded developer.  If you need more proof of this try to run
`Byte.decode("0xFF")`. Because everything in Java is signed that will result in
a `NumberFormatException`, as the max value for a byte is 127.

Things only get worse from there if you want to do things like mask bits,
invert bits, or perform a shift or rotate. There is no syntax for a `byte`
contstant in Java, and when doing bitwise operations everything is cast to
an `int` anyway. That means code for processing bytes is littered with
casts to and from `int`. It is very easy to make a mistake, especially
when you throw in the right shift operator (>>) and the _unsigned_ right
shift operator (>>>).

ByteOps is a single file that you can include in your code to make simple
byte operations a little more sane. It doesn't eliminate the overhead
of performing casts to and from `int`, but it does contain them so that
you can focus on programming.

License
=======
This is free and unencumbered software released into the public domain.

Anyone is free to copy, modify, publish, use, compile, sell, or
distribute this software, either in source code form or as a compiled
binary, for any purpose, commercial or non-commercial, and by any
means.

In jurisdictions that recognize copyright laws, the author or authors
of this software dedicate any and all copyright interest in the
software to the public domain. We make this dedication for the benefit
of the public at large and to the detriment of our heirs and
successors. We intend this dedication to be an overt act of
relinquishment in perpetuity of all present and future rights to this
software under copyright law.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.

For more information, please refer to <http://unlicense.org/>
