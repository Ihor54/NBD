//5.	Average and total amount of money left on credit cards of polish women, grouped by currency
var mapFn = function () {
	for(var idx = 0; idx < this.credit.length; idx++){
	    var key = this.credit[idx].currency;
	    var balance = parseFloat(this.credit[idx].balance);
	    var value = {
	        count: 1,
	        balance: balance
	    };
        emit(key, value);
	}
};

var reduceFn = function(key, values){
    var reducedValue = {
        count: 0,
        balance: 0
    };
    
    for(var idx = 0; idx < values.length; idx++){
        reducedValue.count += values[idx].count;
        reducedValue.balance += values[idx].balance;
    };   
    
    return reducedValue;
};


var finalizeFn = function(key, value){
    var result = {
      avgBalance: value.balance / value.count,
      totalBalance: value.balance
    };
    
    return result;
};

db.people.mapReduce(mapFn, reduceFn, {query: {nationality: "Poland", sex: "Female"}, finalize: finalizeFn, out: "task5"});
printjson(db.task5.find().sort({_id: 1}).toArray());


