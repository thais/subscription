# subscription
Still need to do:

- Create User Entity to vinculate with Subscription
- Add voucher to subscription
- calculate hte final price
- validations and exceptions
- Add test coverage
- docker

# subscription
Creating a product
curl --location --request POST 'http://localhost:8080/products' \
--header 'Content-Type: application/json' \
--data-raw '{"name": "Lambada",
"price": 10.00,
"tax": 20.00,
"duration": 20
}'

View product by id
curl --location --request GET 'http://localhost:8080/products/1' \
--header 'Content-Type: application/json' \
--data-raw '{"name": "Lambada",
"price": 80.00,
"tax": 10.00,
"duration": 30
}'

View all products
curl --location --request GET 'http://localhost:8080/products/' \
--header 'Content-Type: application/json' \
--data-raw '{"name": "Lambada",
"description": "Ritmo Probido",
"price": 80.00,
"tax": 10.00,
"duration": 30
}'

"Buying a product" (duration in days)
(the id is from product)
curl --location --request POST 'http://localhost:8080/subscription' \
--header 'Content-Type: application/json' \
--data-raw '{"name": "mysub", "id": 1, "start": "2021-10-10", "duration": 30}'

"All subscriptions"
curl --location --request GET 'http://localhost:8080/subscription'

"Pause subscriptions"
curl --location --request PUT 'http://localhost:8080/subscription/pause/1'

"Pause subscriptions"
curl --location --request PUT 'http://localhost:8080/subscription/unpause/1'

"Cancel subscriptions"
curl --location --request PUT 'http://localhost:8080/subscription/cancel/1'
>>>>>>> 4a8922dab238baf2d136dddb31165e1092b085d7
