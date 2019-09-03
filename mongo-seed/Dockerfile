FROM mongo

COPY contacts.json /contacts.json
COPY users.json /users.json

CMD mongoimport --host mongodb --db ContactService --collection ContactCollection --drop --type json --file /contacts.json --jsonArray && mongoimport --host mongodb --db ContactService --collection UserCollection --drop --type json --file /users.json --jsonArray