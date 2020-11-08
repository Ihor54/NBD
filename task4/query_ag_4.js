const aggregationTask4 = [
	{
		$project: {
			nationality: 1,
			bmi: {$divide: 
				[
					{$toDouble: "$weight"},
					{$pow: [ 
							{
								$divide:[ {$toDouble: "$height"}, 100]
							}, 
							2
						]
					},
				]}
		}
	},
	{
		$group: {
			_id: "$nationality",
			avgBmi: {$avg: "$bmi"},
			minBmi: {$min: "$bmi"},
			maxBmi: {$max: "$bmi"}
		}
	},
	{
		$sort: { _id: 1}
	}
];
  
  
printjson(db.people.aggregate(aggregationTask4).toArray());