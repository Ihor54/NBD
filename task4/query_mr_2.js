var mapFn = function () {
	for(var idx = 0; idx < this.credit.length; idx++){
	    var key = this.credit[idx].currency;
	    var value = parseFloat(this.credit[idx].balance);
        emit(key, value);
	}
};

var reduceFn = function(key, values){
    return Array.sum(values);
};

db.people.mapReduce(mapFn, reduceFn, {out: "task2"})
printjson(db.task2.find().sort({_id: 1}).toArray());


