# Unix-wc-clone
# Run the code

1. Checkout this repo on to your workspace. 
2. Run the following command at the root level of directory to build the executable (jar)
3. `mvn clean install`
4. The JAR gets created in the target dir of your project, now run your jar
5. `java -jar target/<JAR-file-name>.jar ccwc <flags> <file>`

# Requirements
The functional requirements for wc are concisely described by it’s man page - give it a go in your local terminal now:

`man wc`

The TL/DR version is: wc – word, line, character, and byte count.

## Step Zero
Install Java, Maven, Intellij or your favourite IDE.

Download  this [text from Project Gutenberg](https://www.gutenberg.org/cache/epub/132/pg132.txt) and save it as test.txt.

## Step One
In this step your goal is to write a simple version of wc, let’s call it ccwc (cc for Coding Challenges) that takes the command line option -c and outputs the number of bytes in a file.

If you’ve done it right your output should match this:

>ccwc -c test.txt
341836 test.txt

If it doesn’t, check your code, fix any bugs and try again. If it does, congratulations! On to…

## Step Two
In this step your goal is to support the command line option -l that outputs the number of lines in a file.

If you’ve done it right your output should match this:

>ccwc -l test.txt
7137 test.txt

If it doesn’t, check your code, fix any bugs and try again. If it does, congratulations! On to…

## Step Three
In this step your goal is to support the command line option -w that outputs the number of words in a file. If you’ve done it right your output should match this:

>ccwc -w test.txt
58159 test.txt

If it doesn’t, check your code, fix any bugs and try again. If it does, congratulations! On to…

## Step Four
In this step your goal is to support the command line option -m that outputs the number of characters in a file. If the current locale does not support multibyte characters this will match the -c option.

You can learn more about programming for locales here

For this one your answer will depend on your locale, so if can, use wc itself and compare the output to your solution:

>wc -m test.txt
339120 test.txt

>ccwc -m test.txt
339120 test.txt

If it doesn’t, check your code, fix any bugs and try again. If it does, congratulations! On to…

## Step Five
In this step your goal is to support the default option - i.e. no options are provided, which is the equivalent to the -c, -l and -w options. If you’ve done it right your output should match this:

>ccwc test.txt
7137   58159  341836 test.txt

If it doesn’t, check your code, fix any bugs and try again. If it does, congratulations! On to…

## The Final Step
In this step your goal is to support being able to read from standard input if no filename is specified. If you’ve done it right your output should match this:

>cat test.txt | ccwc -l
7137

If it doesn’t, check your code, fix any bugs and try again. If it does, congratulations! You’ve done it, pat yourself on the back, job well done!