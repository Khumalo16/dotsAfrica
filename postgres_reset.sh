sudo -u postgres psql --command="CREATE USER dotsafrica SUPERUSER PASSWORD 'password';"
sudo -u postgres psql --command="CREATE DATABASE api_dotsafrica OWNER dotsafrica;"

