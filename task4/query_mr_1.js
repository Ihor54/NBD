var mapFn = function () {
	var key = this.sex;
	var value = {
	    count: 1,
	    weight: parseFloat(this.weight),
	    height: parseFloat(this.height)
	};
    emit(key, value);
};

var reduceFn = function (key, values) {
    var reducedVal = {count: 0, weight: 0, height: 0};
    
    for(var idx = 0; idx < values.length; idx++){
        reducedVal.count += values[idx].count;
        reducedVal.weight += values[idx].weight;
        reducedVal.height += values[idx].height;
    }

    return reducedVal;
};

var finalizeFn = function (key, reducedValue) {
    var finalResult = {
        avgHeight: reducedValue.height/reducedValue.count,
        avgWeight: reducedValue.weight/reducedValue.count
    }
   
    return finalResult;
};

printjson(db.people.mapReduce(mapFn, reduceFn, {finalize: finalizeFn, out: {inline: 1}}));