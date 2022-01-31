# :chains: Description 
This app can show actually currency rates by base code, actually base code and history by date/ date and base code / history between dates.

# :rocket: Ways to work 
- Use `//localhost:8080/get_for_code?baseCode=USD` to get actually rates by сurrency (USD).
- Use `//localhost:8080/history?from=2022-01-15&to=2022-01-20` to get rates history between dates for all currency. 
- Use `//localhost:8080/by_date?date=22-01-15&baseCode=USD` to get rates history by date and currency (USD). 
- Use `//localhost:8080/by_date_and_baseCode?from=2022-01-15&to=2022-01-20&baseCode=USD` to get rates history between dates for currency (USD).
- Use `//localhost:8080/all_available` to get all availeble currency.
