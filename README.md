![header.jpg](images%2Fheader.jpg)

# Jetpack Compose Battle - Qualify Round 
# Thai
> English at below

Jetpack Compose Battle เป็นงานแข่งขันที่จะให้นักพัฒนาแอนดรอยด์ในประเทศไทยแข่งกันสร้าง UI ด้วย Jetpack Compose ที่เป็น UI Framework ตัวใหม่ล่าสุดทางทีมแอนดรอยด์

## รายละเอียดสำหรับรอบคัดเลือก
* การเข้าร่วมแข่งขันในรอบคัดเลือกสามารถเริ่มทำโจทย์ได้ตั้งแต่วันที่ 17 มกราคม 2024 จนถึงวันหมดเขต
* ผู้เข้าแข่งขันจะต้องสร้าง UI ด้วย Jetpack Compose ในแต่ละข้อให้ถูกต้องตามที่กำหนดไว้ใน Figma
* คะแนนจะถูกคำนวณจากความถูกต้องของ UI โดยตรวจสอบจาก Snapshot Testing
* การแข่งขันในรอบคัดเลือกจะหมดเขตภายในวันที่ 27 มกราคม 2024 เวลา 23:59 น. และผลการแข่งขันจะประกาศภายในวันที่ 31 มกราคม 2024
* ผู้ที่เข้ารอบคัดเลือกจะได้ไปแข่งขันในรอบสุดท้าย ณ วันเสาร์ที่ 17 กุมภาพันธ์ 2024 ที่จะจัดขึ้นที่บริษัท MuvMi

## ของรางวัล
* อันดับที่ 1 Android Mini Collectible @Work Series - Tech Support / IT / Engineer

![รางวัลอันดับที่ 1](images%2Fprize_first.png)

* อันดับที่ 2 Android Mini Collectible @Work Series - Developer / Coder / Cyber Security

![รางวัลอันดับที่ 2](images%2Fprize_second.png)

* อันดับที่ 3 หนังสือ The Team That Built the Android Operating System ของ Chet Haase

![รางวัลอันดับที่ 3](images%2Fprize_third.png)

* อันดับที่ 4 หุ่นยนต์ไขลาน Android Wind-up

![รางวัลอันดับที่ 4](images%2Fprize_fourth.png)

นอกจากนี้ผู้เข้าแข่งขันในรอบสุดท้ายทุกท่านจะได้รับของสมนาคุณจากบริษัท MuvMi อีกด้วย

## กติกาในรอบคัดเลือก
1. ผู้เข้าแข่งขันจะต้องสร้าง UI ด้วย Jetpack Compose ที่ Fork จาก Repository นี้เท่านั้น
2. UI ที่จะต้องสร้างมีทั้งหมด 3 หน้าด้วยกัน สามารถดูได้จาก Figma -> [โจทย์รอบคัดเลือก](https://www.figma.com/file/AsOdXenDJAp89aTxGT996v/Jetpack-Compose-Battle---Qualify-Day?type=design&node-id=54766%3A246&mode=dev)
3. โจทย์มีทั้งหมด 3 ข้อ โดยจะอยู่ในไฟล์ดังนี้
   * `<project>/common/src/main/java/com/github/thailandandroiddeveloper/common/ui/screen/Qualify1Screen.kt`
   * `<project>/common/src/main/java/com/github/thailandandroiddeveloper/common/ui/screen/Qualify2Screen.kt`
   * `<project>/common/src/main/java/com/github/thailandandroiddeveloper/common/ui/screen/Qualify3Screen.kt`
4. สามารถสร้าง Composable Function เพิ่มในไฟล์ดังกล่าวได้ตามใจชอบ ขอแค่ห้ามแก้ไขข้อมูลใน `@Preview` ที่อยู่ในไฟล์ดังกล่าวก็พอ 
5. ห้ามใช้รูปภาพจากภายนอก ให้ใช้รูปที่เตรียมไว้ในโปรเจคนี้เท่านั้น โดยจะอยู่ที่ `<project>/common/src/main/res`
6. ชื่อไฟล์รูปภาพทั้งหมดให้ดูชื่อจากใน Figma และเรียกใช้งานผ่าน Android Resource ได้เลย
7. ค่าต่าง ๆ เช่น ขนาด ฟอนต์ ความหนาของตัวอักษรไม่ต้องสร้างขึ้นมาเอง ให้ดูจากใน Figma และเรียกใช้งานผ่าน `MaterialTheme` ได้เลย ยกตัวอย่างเช่น `MaterialTheme.typography.headlineMedium.fontSize` เป็นต้น
8. ค่าสีที่ใช้ใน UI ไม่ต้องสร้างขึ้นมาเอง ให้ดูจากใน Figma และเรียกใช้งานผ่าน `MaterialTheme` ได้เลย เช่น `MaterialTheme.colors.primary` เป็นต้น
9. คะแนนจะถูกคำนวณจากการรัน Snapshot Testing ด้วย Paparazzi โดยผู้เข้าแข่งขันสามารถทดสอบได้ด้วยการใช้คำสั่ง `./gradlew :screenshot-test:verifyPaparazziDebug` เผื่อดูผลลัพธ์ได้ก่อนส่งโจทย์
   * โดยผลลัพธ์ที่ได้จะอยู่ใน `<project>/screenshot-test/diff/` ที่จะบอกผลต่างของภาพที่ได้จากโค้ดเทียบกับภาพที่ถูกต้อง
   * ค่าที่ได้จากผลของ Snapshot Testing จะมีค่าเป็น % เมื่อเทียบกับภาพต้นฉบับ
   * ถ้าที่ได้มีค่าเท่ากับ 0 แปลว่าผลลัพธ์ถูกต้องแบบ 100%
10. ภาพต้นฉบับที่ใช้เปรียบเทียบใน Snapshot Testing จะอยู่ใน `/screenshot-test/src/test/snapshots/images` (ห้ามแก้ไข)

## การส่งโจทย์
* ให้ส่งโจทย์เป็น GitHub URL แล้วกรอกข้อมูลส่วนตัวพร้อมกับ URL ดังกล่าว -> [ส่งโจทย์รอบคัดเลือก](https://forms.gle/FQesDoGdFcuLacdt7)
* สามารถทำเป็น Private Repository เพื่อความสบายใจได้ แต่จะต้องเชิญทีมงานเข้าไปเป็น **Admin** ใน Repository ดังกล่าวด้วย
  * `judrummer` หรือ `Tipatai Puthanukunkit`
  * `akexorcist` หรือ `Akexorcist`
* ผลการแข่งขันจะประกาศภายในวันที่ 31 มกราคม 2024

---

# English
Jetpack Compose Battle is a competition challenging Android developers in Thailand to create UIs using Jetpack Compose, the latest UI framework from the Android team.

## Qualifying Round Details
* Participants can start working on the challenges from January 17, 2024, until the deadline.
* Competitors must create UIs with Jetpack Compose based on the specifications provided in Figma.
* Scores will be calculated based on the accuracy of the UI as assessed by Snapshot Testing.
* The qualifying round concludes on January 27, 2024, at 23:59, with results announced on January 31, 2024.
* Qualifiers will proceed to the final round on February 17, 2024, at MuvMi's headquarters.

## Prizes
* อ1st Place: Android Mini Collectible @Work Series - Tech Support / IT / Engineer

![รางวัลอันดับที่ 1](images%2Fprize_first.png)

* 2nd Place: Android Mini Collectible @Work Series - Developer / Coder / Cyber Security

![รางวัลอันดับที่ 2](images%2Fprize_second.png)

* 3rd Place: "The Team That Built the Android Operating System" book by Chet Haase

![รางวัลอันดับที่ 3](images%2Fprize_third.png)

* 4th Place: Android Wind-up Robot

![รางวัลอันดับที่ 4](images%2Fprize_fourth.png)

Additionally, all finalists will receive special gifts from MuvMi.

## Qualifying Round Guidelines
1. Participants must create UIs with Jetpack Compose by forking from this repository only.
2. The UI to be created consists of 3 screens, detailed in Figma -> [Qualifying Round Challenges](https://www.figma.com/file/AsOdXenDJAp89aTxGT996v/Jetpack-Compose-Battle---Qualify-Day?type=design&node-id=54766%3A246&mode=dev)
3. The challenges are in 3 separate files:
    * `<project>/common/src/main/java/com/github/thailandandroiddeveloper/common/ui/screen/Qualify1Screen.kt`
    * `<project>/common/src/main/java/com/github/thailandandroiddeveloper/common/ui/screen/Qualify2Screen.kt`
    * `<project>/common/src/main/java/com/github/thailandandroiddeveloper/common/ui/screen/Qualify3Screen.kt`
4. Composable functions can be added as desired, but refrain from modifying data in `@Preview` in those files.
5. Do not use external images; use those prepared in the project located at `<project>/common/src/main/res`.
6. All image file names should match those in Figma and be accessed through Android Resource.
7. Various values like size, font, and text thickness can be derived from Figma and accessed through MaterialTheme.
8. UI color values can be obtained from Figma and accessed through MaterialTheme.
9. Scores will be calculated through Snapshot Testing with Paparazzi. Competitors can test using `./gradlew :screenshot-test:verifyPaparazziDebug` before submission.
    * Results will be in `<project>/screenshot-test/diff/`, indicating differences from the correct images.
    * Snapshot Testing results are presented as percentages comparing with the original images.
    * A result of 0 means 100% accuracy.
10. Original images for Snapshot Testing are in `/screenshot-test/src/test/snapshots/images` (do not modify).

## Submission
* Submit the GitHub URL of your project and fill in your personal information -> [Submission form](https://forms.gle/FQesDoGdFcuLacdt7)
* The repository can be private for peace of mind, but the judging team must be invited as **Admin**:
    * `judrummer` or `Tipatai Puthanukunkit`
    * `akexorcist` or `Akexorcist`
* Results will be announced on January 31, 2024.


## Sponsors
* [MuvMi](https://muvmi.co/)
* [LINE MAN Wongnai](https://lmwn.com/)
