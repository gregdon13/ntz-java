# ntz-java
ntz is a commandline notes taker

## What is ntz?

A command line note tool that doesn't involve terminal based editors, but does involve Java.
You've been provided with a very simple file backed data store called `FileMap`.
It acts like a Key/Value database, which can be stored in a file.
It is a subclass of `HashMap<String,NoteList>` and all it does is `load()` and `save()` a itself to
a file named "ntz.db".
It's purpose is to show you a simple way to persist your Notez' data into a file.

A `NoteList` is merely an ArrayList<String>. 
Each Item in the FileMap should use the key String for the Category name, and then append a notes to the NoteList held as the map's value.

This lab requires you to figure out how to take things from the command line and manipulate a `database` to
store text notes.

## Why?

Keeping track of a small list of things to remember or stuff that needs doing is a pain. 
Remembering its location, manually accessing it, formatting it and all of the clicking that entails, 
is something many find unpleasant.

Other command line note tools out there are...clunky. 
They require interacting with vim or nano, and manual formatting. 
Yuck.

ntz takes command line arguments and builds tidy todo/remember lists using the inherent 
neatness of Java. 
The result is a notes system that is easily manipulated with the command line 
using ntz' interface.

## What's it look like? - Usage

### Showing notes.
Typing `ntz` with no arguments should display all your notes.
It should number them so you can perform forget/change on them.

```
ntz
1) "hello!"
2) "second note"
```

### adding/forgetting and changing notes

ntz has four commandline options.

* [-r]emember
* [-c] creates and/or appends to a category
* [-f]orget a note
* [-e]dit (replace) a note

#### Remember

Adds a note to the general category.

```
ntz -r "This is a note"
# which should be the same as 
ntz -c "General" "This is a note"
```

#### Create/Append to Category

Adds another note to a category, if the category doesn't exist,
adds a new category and appends the note to it.
```
ntz
1) "hello!"
2) "second note"

ntz -c "Todo" "Buy Milk."

ntz
1) "hello!"
2) "second note"
 Todo
1) "Buy Milk."
```

#### Forget a note

Removes a note from a category

```
ntz
1) "hello!"
2) "second note"

ntz -r 1

ntz
1) "second note"
```

### Edit a note

Replace a note with a new one.

```
ntz
1) "hello!"
2) "second note"

ntz -r 2 "replaced second note"

ntz
1) "hello!"
2) "replaced second note"
```

## BackEnd

Yes, the backend (the FileMap) is a very crude database. Feel free to use another one.
These are all suggestions:

* SQLite3
* BerkeleyDB
* jdbm2
* BananaDB
* REDIS
* anything else your heart desires.

## Installation (Once you have it written)

This is waving hands.
Need real instructions here.

1. Look at the `ntz.sh` file.
2. It might work for you.
3. Place it somewhere that's in your shell's $PATH. Either /bin, /usr/bin or ~/bin
4. Add this line to your .bashrc or .zshrc in the alias section (which is probably in ~/) -> alias ntz='ntz.sh'


That should do it. To make ntx executable in a shell, just `chmod +x ntz` and it'll probably do the trick.

