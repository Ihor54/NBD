const aggregationTask2 = [
	{
		$unwind: "$credit"
	},
	{
		$group: {
			_id: "$credit.currency",
			totalAmount: {$sum: { "$toDouble": "$credit.balance"}}
		}
	},
	{
		$sort: {
			_id: 1
		}
	}
];
  
  
printjson(db.people.aggregate(aggregationTask2).toArray());