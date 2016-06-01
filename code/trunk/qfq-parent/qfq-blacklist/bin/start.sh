#!/bin/sh

#获取脚本工作路径
work_dir=$(cd `dirname $0`; pwd)  
#echo $work_dir

#最小堆内存
min=512m
#最大堆内存
max=2048m
#程序入口
main=com.qfq.blacklist.main.Start
processName=qfq_black

#设置classPath
export CLASSPATH=$CLASSPATH

for i in $work_dir/../lib/*.jar;  
  do CLASSPATH=${CLASSPATH}:$i
done

CLASSPATH=${CLASSPATH}:$work_dir/../conf

for i in $work_dir/../conf/*;  
  do CLASSPATH=${CLASSPATH}:$i
done

#echo $CLASSPATH
declare -x PATH="/usr/kerberos/sbin:/usr/kerberos/bin:/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin:/usr/X11R6/bin:/usr/lib/jdk/bin:/root/bin"
app=`ps aux | grep $processName | grep -v grep | wc -l` 

echo $app
if [ "$app" -eq 0 ]
 then 
 {
	#设置JRE
	export PATH=$work_dir/../jre1.7.0_45/bin:$PATH
	java -DprocessName=$processName -cp $CLASSPATH -Xms$min -Xmx$max $main #> /dev/null &
 }
 else
   echo  "Service is already started, exit"
fi
