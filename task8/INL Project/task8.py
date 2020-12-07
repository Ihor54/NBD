import riak

def add_product(p_key, p_data):
	product = my_bucket.new(p_key, data=p_data)
	product.store()

def fetch_and_print(p_key):
	fetch_p = my_bucket.get(p_key)
	print(fetch_p.encoded_data)
	return fetch_p

bucket_name = 's_15293'
ssd_key = 'ssd'

my_client = riak.RiakClient(protocol='http', host='127.0.0.1', http_port=8098)
my_bucket = my_client.bucket(bucket_name)
#add product to db
ssd_data = {"name": "970 EVO Plus", "producer":"Samsung", "price":350, "capacityGb": 500}
add_product(ssd_key, ssd_data)
#retrieve product
ssd = fetch_and_print(ssd_key)
#modify product
ssd.data["name"] = "Samsung 970 EVO Plus updated"
ssd.store()
#retrieve updated
ssd = fetch_and_print(ssd_key)
#delete
ssd.delete()
#try to retrieve deleted
ssd = fetch_and_print(ssd)








