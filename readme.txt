Demo連結:https://drive.google.com/drive/u/4/folders/1VU0itkwJOCMzojSfpk5c4shkbQzXEKlR

在第十組_OOPII_Project_Final.zip裡面會有三個圖片資料夾為card、Ccard、Resource，分別是遊戲畫面裡顯示的卡牌圖片、收復卡牌視窗裡的卡牌圖片以及遊戲畫面裡按鈕、背景、卡牌背面等等的圖片。此外還有一個資料夾Still_trying裡面放的是還未嘗試成功及融合到主遊戲裡面的程式檔。其餘19個java檔案為遊戲運行所需用到的程式碼檔，另外card.txt及cardText.txt是CardInfo.java及CardText.java讀檔時會使用到的檔案。注意請勿隨意移動檔案位置或更改檔案名稱，會造成使用上的錯誤。

若要使用此程式碼玩遊戲，請先安裝好Java執行環境再於cmd或編輯器裡輸入javac Main.java的指令，電腦將會開始編譯以下檔案：Card.java、CardInfo.java、CardText.java、Role.java、RoleInfo.java、DrawStraw.java、DrawLotsPage.java、Collections.java、PairCard.java、AutoPairCard.java、MessageDisplay.java、ComputerPlayer.java、LetYouSleep.java、Win.java、Rulepage.java、Menupage.java、GamePage.java、MainPage.java。若電腦無自動編譯上述18個檔案，可以按照上述的順序編譯並在最後編譯Main.java檔。編譯完成後，只需輸入指令java Main便可以開始遊戲。

先至Java Oracle(https://www.oracle.com/tw/java/technologies/javase-downloads.html)安裝最新Java SE版本的套件，本次使用說明的版本是Windows x64 Installer Java SE 11，Oracle也提供了Linux、macOS、Solaris及Windows使用者也可以依照自己的硬體設備選擇安裝相容的版本套件。在電腦安裝完套件之後，請至系統設定裡面搜尋「編輯系統環境變數」以設定環境變數，在系統變數的地方請新增名為JAVA_HOME的環境變數，變數值放的是方才安裝Java套件的位置，如C:\Program\Java\jdk-11.0.2，同處也會發現一個變數名稱為Path 在最上方將Java套件裡的bin放上去，如C:\Program\Java\jdk-11.0.2\bin，接著在下方也要加入JAVA_HOME的變數內容，完成上述就設定完環境變數了。

我們使用Sublime Text(https://www.sublimetext.com/)來做程式開發，使用者可以依照自己的編輯習慣使用編輯器。先至Sublime Text下載安裝套件，將套件安裝至電腦上後選擇Tools > Install Package Control開啟後輸入ChineseLocalization安裝就可以將英文介面改成中文介面。開啟工具 > 編譯系統 > 新增編譯系統，此時會新開一個介面讓使用者可以把新編譯系統的指令輸入，我們已經編譯內容附到檔案裡，使用者只需要將JavaC.txt的內容貼上即可。

建立一個簡單的Java檔，此Java檔可以將Hello Word印到螢幕上。利用ctrl + B即可編譯此檔案。編譯成功後，在Sublime Text視窗畫面的下方會出現一欄Consloe裡面會顯示出Hello Word及編譯時間。此表示已經成功安裝Java套件了。
