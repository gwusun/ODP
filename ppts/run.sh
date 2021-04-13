for host in `ls`
do
echo =============== start "unzip" [$host] to [${host%.odp*}] =================== 
unzip -o   $host -d ${host%.odp*}
echo 
echo 
done