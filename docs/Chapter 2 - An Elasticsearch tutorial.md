## An Elasticsearch tutorial
![Elasticsearch tut](https://raw.githubusercontent.com/khuongdv/melk-boilerplate/master/imgs/elasticsearch-tutorial.png "Elasticsearch tut")
- Elasticsearch often know as a search server, but it is a NoSQL Database (it stores data in a unstructured way)
### How to install Elastic Search
- Requires: Java 7 or higher, Must have supported OS in [this list](https://www.elastic.co/support/matrix)
- We can download standalone elasticsearch or use YUM/APT commands
- For now, download the distribution (standalone elasticsearch), extract it to a directory. We can start Elasticsearch by running __bin/elasticsearch__
- Go to __http://127.0.0.1:9200__ to verify that Elasticsearch properly runs, below is a sample output:
```
{
 "name" : "Bloodhawk",
 "cluster_name" : "elasticsearch",
 "version" : {
 "number" : "2.1.1",
 "build_hash" : "40e2c53a6b6c2972b3d13846e450e66f4375bd71",
 "build_timestamp" : "2015-12-15T13:05:55Z",
 "build_snapshot" : false,
 "lucene_version" : "5.3.1"
 },
 "tagline" : "You Know, for Search"
 }
```
### Creating an index in Elasticsearch
- Adding data to Elasticsearch is called indexing (the data will be placed in Apache Lucene indexes)
- We can add data to Elasticsearch using POST or PUT http requests.
- Use PUT: we have to specify ID for data items, use POST: we want Elasticsearch to generate ID for data items
- Data to be sent is in JSON form
### ElasticSearch query
- Once we have data indexed into Elasticsearch, we can start searching and analyzing it
- Simple case: fetching a single item, use http request with GET method
```
curl -X GET http://127.0.0.1:9200/app/users/4

{
 "_id": "4",
 "_index": "app",
 "_source": {
 "id": 4,
 "last_login": "2015-01-18 12:34:56",
 "username": "john"
 },
 "_type": "users",
 "_version": 1,
 "found": true
 }
```
- In result: Fields with an underscore are meta fields, ___source__ object is the original document that wasindexed
- Use ___search__ endpoint
```
curl -X GET http://127.0.0.1:9200/_search?q=logged
 {
 "_shards": {
 "failed": 0,
 "successful": 10,
 "total": 10
 },
 "hits": {
 "hits": [
 {
 "_id": "AVJWJkaW0D5QbnIxzP5S",
 "_index": "logs",
 "_score": 0.095891505000000002,
 "_source": {
 "admin": false,
 "message": "User logged in",
 "timestamp": "2015-01-18 12:34:56",
 "user_id": 4
 },
 "_type": "my_app"
 }
 ],
 "max_score": 0.095891505000000002,
 "total": 1
 },
 "timed_out": false,
 "took": 62
 }
```
- Some info returned:
    - __took__: The time in milliseconds the search took
    - __timed_out__: if the search timed out
    - __shards__ The number of Lucene shards searched, and their success and failure rates
    - __hits__: the actual results along with meta information for the results
- By providing only a word, all of the fields of all the documents are searched for that word. We can use more complicated query
- Elasticsearch also provides [request body search](https://www.elastic.co/guide/en/elasticsearch/reference/current/search-request-body.html).
    - Mix & match different options to get the results that you require
    - Some of the options are: GEO query, scripted query
- Filter vs query: (Learn more...)
### Removing Elasticsearch data
- Send a http DELETE request to the index URI
- We can specify the ID in the body, or use a query instead