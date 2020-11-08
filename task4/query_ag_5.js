const aggregationTask5 = [
	{
		$unwind: "$credit"
	},
	{
		$project:{
			sex: 1,
			nationality: 1,
			currency: "$credit.currency",
			cardBalance: {"$toDouble": "$credit.balance"}
		}
	},
	{
		$match: {
			nationality: "Poland",
			sex: "Female"
		}
	},
	{
		$group: {
			_id: "$currency",
			averageAmount: {$avg: "$cardBalance"},
			totalAmount: {$sum: "$cardBalance"}
		}
	},
	{
		$sort:{
			_id: 1
		}
	}
];
  
  
printjson(db.people.aggregate(aggregationTask5).toArray());