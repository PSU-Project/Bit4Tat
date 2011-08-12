COMPILER = javac
SRC = ./src
DEST = ./bin
PROG = bit4tat

$(PROG):$(SRC)/$(PROG).java
	-cd $(SRC); rm -rf ./*.class
	-cd $(SRC); $(COMPILER) ./$(PROG).java
	-rm -rf bin
	-mkdir bin
	-mv ./$(SRC)/*.class ./$(DEST)
	-mv ./opening.txt ./$(DEST)
	-@echo
	-@echo Installation complete!
	-@echo 
	-@echo For usage: 
	-@echo ./bit4tat
	-@echo

clean: 
	rm -rf ./$(DEST)