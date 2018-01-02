#!/bin/bash

cd ~ #using absolute path to change dir to home dir

if [ ! -d project ] #detecting the dir
then
	mkdir project #if not, create the dir
fi

cd ./project #moving into the project subdir using relative path

#almost the same thing as above
if [ ! -d cs206 ]
then
	mkdir cs206
fi

cd ./cs206

if [ -d $1 ] #if there exists a dir with the name user enters
then
	echo 'This project name has already been used.' #print out the error message
else
	mkdir $1 archive backup docs assets database source #create the whole dir structure
fi

cd ./source

touch backup.sh #create the file
chmod 755 backup.sh #good to run 
echo "#!/bin/bash" > backup.sh
echo "cp *.c ../backup" >> backup.sh #copy the certain formats of files
echo "cp *.h ../backup" >> backup.sh
echo "exit 0" >> backup.sh #exit backup.sh

echo 'You project directories have been created.' #print the required message