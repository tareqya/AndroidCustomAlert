# AndroidCustomAlert

Android library for showing 2 types of alerts 
 1) Normal alert message
 2) Yes No alert message

## Setup

Step 1. Add it to your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency:

```
	dependencies {
    implementation 'com.github.tareqya:AndroidCustomAlert:v1.0.0'
	}
```

## Usage

Success alert message

```java
      AlertMsg dialog = new AlertMsg(this)
                .setTitle("Custom Alert")
                .setMessage("This is a custom alert dialog!")
                .setPosButtonText("Ok")
                .setMsgType(AlertMsg.SUCCESS_MSG)
                .setPosClickListener(new AlertMsg.OnPosButtonClickListener() {
                    @Override
                    public void onPosButtonClicked() {
                        Toast.makeText(MainActivity.this, "Pos button clicked", Toast.LENGTH_SHORT).show();
                    }
                });

    dialog.show();

```
![success](https://github.com/tareqya/AndroidCustomAlert/assets/35847896/9fa5f5d7-d691-4813-894c-d7d2a78307a3)


Error alert message

```java
      AlertMsg dialog = new AlertMsg(this)
                .setTitle("Custom Alert")
                .setMessage("This is a custom alert dialog!")
                .setPosButtonText("Ok")
                .setMsgType(AlertMsg.ERROR_MSG)
                .setPosClickListener(new AlertMsg.OnPosButtonClickListener() {
                    @Override
                    public void onPosButtonClicked() {
                        Toast.makeText(MainActivity.this, "Pos button clicked", Toast.LENGTH_SHORT).show();
                    }
                });

    dialog.show();

```
![error](https://github.com/tareqya/AndroidCustomAlert/assets/35847896/f6896920-8d4b-4579-81bd-c98450cdbf5d)


Info alert message

```java
      AlertMsg dialog = new AlertMsg(this)
                .setTitle("Custom Alert")
                .setMessage("This is a custom alert dialog!")
                .setPosButtonText("Ok")
                .setMsgType(AlertMsg.INFO_MSG)
                .setPosClickListener(new AlertMsg.OnPosButtonClickListener() {
                    @Override
                    public void onPosButtonClicked() {
                        Toast.makeText(MainActivity.this, "Pos button clicked", Toast.LENGTH_SHORT).show();
                    }
                });

    dialog.show();

```
![info](https://github.com/tareqya/AndroidCustomAlert/assets/35847896/2d611b57-7de9-4eb7-9bd1-8d17cacd64c3)



Yes No alert message

```java
   YesNoDialog yesNoDialog = (YesNoDialog) new YesNoDialog(this)
                .setTitle("Custom Alert")
                .setMessage("This is a custom alert dialog!")
                .setPosButtonText("Yes")
                .setMsgType(AlertMsg.INFO_MSG);

        yesNoDialog.setNegButtonClickListener(new YesNoDialog.OnNegButtonClickListener() {
            @Override
            public void onNegButtonClicked() {
                Toast.makeText(MainActivity.this, "Neg button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        yesNoDialog.setPosClickListener(new AlertMsg.OnPosButtonClickListener() {
            @Override
            public void onPosButtonClicked() {
                Toast.makeText(MainActivity.this, "Pos button clicked", Toast.LENGTH_SHORT).show();

            }
        });

        yesNoDialog.show();

```
![yesno](https://github.com/tareqya/AndroidCustomAlert/assets/35847896/931cfd2a-ed81-4912-9ea8-2d3874d522f5)

