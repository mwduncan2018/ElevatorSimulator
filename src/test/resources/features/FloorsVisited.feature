Feature: Floors Visited Provided In Order

  Scenario: Provide floors visited, many floors visited
	Given the elevator starts on <start>
	When the elevator moves to <first>
	And the elevator moves to <second>
	And the elevator moves to <third>
	And the elevator moves to <fourth>
	Then the floors visited in order are "<floorsVisitedInOrder>"
	
	Examples:
	| start	| first	| second | third | fourth | floorsVisitedInOrder |
	| 12	| 2		| 9		 | 1     | 32     | 12,2,9,1,32          |
	| 1     | 2     | 3      | 4     | 5      | 1,2,3,4,5            |
	| 5     | 10    | 15     | 20    | 25     | 5,10,15,20,25        |

  Scenario Outline: Provide floors visited, no floors visited
	Given the elevator starts on <start>
	Then the floors visited in order are "<floorsVisitedInOrder>"
	
	Examples:
	| start	| floorsVisitedInOrder |
	| 12 	| 12                   |
	| 1     | 1                    |
	    
  Scenario Outline: Provide floors visited, one floor visited
	Given the elevator starts on <start>
	When the elevator moves to <first>
	Then the floors visited in order are "<floorsVisitedInOrder>"
	
	Examples:
	| start	| first	| floorsVisitedInOrder |
	| 12	| 2		| 12,2                 |
	| 1     | 2     | 1,2                  |
	| 5     | 10    | 5,10                 |
