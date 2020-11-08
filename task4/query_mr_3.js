var mapFn = function () {
	emit(this.job, this.job);
};

var reduceFn = function(key, values){
    return values;
};

var finalizeFn = function(key, value){
    var set = new Set(value);
    var v = set.values();
    return v.next().value;
};


db.people.mapReduce(mapFn, reduceFn, {finalize: finalizeFn, out: "task3"});
printjson(db.task3.find().sort({_id:1}).toArray());


