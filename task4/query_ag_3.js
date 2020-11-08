const aggregationTask3 = [
	{
		$group: {
			_id: "$job"
		}
	},
	{
		$sort: {
			_id: 1
		}
	}
];
  
  
printjson(db.people.aggregate(aggregationTask3).toArray());