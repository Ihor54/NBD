var mapFn = function () {
	var key = this.nationality;
	var weight = parseFloat(this.weight);
	var height = parseFloat(this.height)/100;
	var bmi = weight/height/height;
	var value = {
	    count: 1,
	    totalBmi: bmi,
	    minBmi: bmi,
	    maxBmi: bmi
	};
    emit(key, value);
};

var reduceFn = function(key, values){
    var reducedValue = {
        count: 0,
        totalBmi: 0,
	    minBmi: 100,
	    maxBmi: 0 };
	    
    for(var idx = 0; idx < values.length; idx++){
        reducedValue.count += values[idx].count;
        reducedValue.totalBmi += values[idx].totalBmi;
        if(values[idx].minBmi < reducedValue.minBmi) { reducedValue.minBmi = values[idx].minBmi }
        if(values[idx].maxBmi > reducedValue.maxBmi) { reducedValue.maxBmi = values[idx].maxBmi }    
    };
    
    return reducedValue;
};


var finalizeFn = function(key, value){
    var result = {
      avgBmi: value.totalBmi / value.count,
      minBmi: value.minBmi,
      maxBmi: value.maxBmi  
    };
    
    return result;
};

db.people.mapReduce(mapFn, reduceFn, {finalize: finalizeFn, out: "task4"});
printjson(db.task4.find().sort({_id: 1}).toArray());
