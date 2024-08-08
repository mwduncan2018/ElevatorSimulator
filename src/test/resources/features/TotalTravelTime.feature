Feature: Total Travel Time

  Scenario Outline: Travel time, many floors visited
	Given the elevator starts on <start>
	When the elevator moves to <first>
	And the elevator moves to <second>
	And the elevator moves to <third>
	And the elevator moves to <fourth>
	Then the total travel time is <travelTime>
	
	Examples:
	| start	| first	| second | third | fourth | travelTime |
	| 12    | 2     | 9      | 1     | 32     | 560        |
	| 1     | 2     | 3      | 4     | 5      | 40         |
	| 5     | 10    | 15     | 20    | 25     | 200        |


  Scenario: Travel time, no floors visited
    Given the elevator starts on
    | 10 |
    Then the total travel time is
    | 0 |
    
  Scenario: Travel time, one floor visited
    Given the elevator starts on
    | 1 |
    When the elevator moves to
    | 5 |
    Then the total travel time is
    | 40 |