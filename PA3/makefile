JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		  PA3.java \
		  Tree.java \
		  Node.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
	
