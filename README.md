# Naive CRUD in Scala

This is a sample code to demonstrate CRUD in Scala.

## A Hands-on Experience

The following steps were taken to quickly catch up with Scala,

1. The [Scala Cheatsheet](https://docs.scala-lang.org/cheatsheets/) was reviewed to recall syntactic constructions.
2. The [Naming Conventions](https://docs.scala-lang.org/style/naming-conventions.html) of Scala were reviewed.
3. Some community-driven lists of useful Scala libraries, frameworks and software were reviewed (e.g. [Lauri's Awesome Scala](https://github.com/lauris/awesome-scala) or [LibHunt's Scala](https://scala.libhunt.com/)).
4. To polish Scala code reading skills, some Scala open source projects in *Github* written reviewed.
5. The [Scala Metals](https://scalameta.org/metals/) was employed in [Visual Studio Code](https://code.visualstudio.com/) along with [sbt](https://www.scala-sbt.org/) as the build tool.
6. A *Metals* project was created and configured and a *Github* repository along with a `.gitignore` file (using [gitignore.io](https://gitignore.io)) was created.
7. To implement CRUD, [Slick](https://scala-slick.org/) was used as the Functional Relational Mapping (FRM) library.
8. The [SQLite](https://www.sqlite.org/) and [H2 Database](https://www.h2database.com/) were candidates for this implementation. 
The *H2 Database* was selected in its **in-memory** mode.
9. The program was implemented according to Slick's documents and other sources such as *Github* and *Stack Overflow*. 