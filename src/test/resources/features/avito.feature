Feature: "Search in Avito"

  Scenario Outline: "Find and display the first n prices of products on request"

    When Follow the link Avito page
    Then Select category <category>
    Then In the search field write <StringForSearch>
    Then Click on the dropdown list of regions
    Then Enter region <city>
    Then Click on the button “Show n ads”
    Then Activate the checkbox “with photo only”
    Then Select <sort> in the sort drop down list
    Then Output to the console Price value of the first <quantity> items
    Then Close browser

    Examples:
      | category              | StringForSearch | city        | sort    | quantity |
      | ОргтехникаИРасходники | Принтер         | Владивосток | Дороже  | 10       |
      | ТоварыДляКомпьютера   | Монитор         | Иркутск     | Дешевле | 7        |
