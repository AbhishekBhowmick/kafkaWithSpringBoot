curl -X PUT -u "elastic:changeme" 'localhost:9200/transaction_musti/_mapping/Transaction?pretty' -H 'Content-Type: application/json' -d @save_transaction_mapping.json
