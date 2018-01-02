#This is the detailed codes and explanations of COMP 206, A1Q2.
#Faced problem when trying to change my prompt:
#problem solved,just using the following command:
PS1="Zisheng Ye: "
PS1="[Zisheng Ye][\h][\w]" 
#the second one is better, \h for the hostname, \w for the current working dir
#then it's done.
#Easy to create directory structure:
[zye26][linux][~] pwd #showing current directory
/home/2017/zye26
[zye26][linux][~] mkdir Projects #creating new empty dir
[zye26][linux][~] ls #list all the contents
a1.txt   Documents  Music     Projects  Templates  Videos
Desktop  Downloads  Pictures  Public    try
[zye26][linux][~] cd Projects #go into a different dir
[zye26][linux][~/Projects] mkdir COMP206
[zye26][linux][~/Projects] cd COMP206
[zye26][linux][~/Projects/COMP206] mkdir ass1
[zye26][linux][~/Projects/COMP206] cd ass1
[zye26][linux][~/Projects/COMP206/ass1] mkdir archive backup docs assets database source
[zye26][linux][~/Projects/COMP206/ass1] ls
archive  assets  backup  database  docs  source

