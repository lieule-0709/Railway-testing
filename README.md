# Railway-testing

1. Clone repository
2. Load Gradle library with file build.gradle
3. Add run/debug configurations
  - Select test kind: Suite
  - Suite: select file xml expected to run on Chrome, FireFox or Edge
4. Add environment variables (USERNAME, PASSWORD)
5. Run test cases.


NOTES:
- If you want to change data for testing. Open file data.json and edit it.
- For Chrome and FireFox, my project run headless as default. You can change running mode in method "beforeClass" of class "BaseTest".
- After the run is complete, the output report is logged with the name corresponding to the browser. 
  On the next run, in case the report already exists, it will be replaced by a new report. 
  Therefore, remember to check and save the old report before running.
