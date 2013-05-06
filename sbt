java -Xms512M -Xmx1536M -Xss1M -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=384M -Dfile.encoding=UTF-8 -jar `dirname $0`/launcher/sbt-launch.jar "$@"
