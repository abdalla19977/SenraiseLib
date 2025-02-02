# SenraisePrinter

Wrapper library for Senraise POS printers

## Features

- Printer management
  - Text printing with custom formatting
  - Table printing
  - Image printing
  - Paper feed control
  - Text alignment

## Installation

Add the following dependency to your project:

```build.gradle(app)
implementation 'com.github.aballa19977:SenraiseLib:1.0'
```

```build.gradle(project)
repositories {
        google()
        mavenCentral()
        maven { url "https://jitpack.io" }
    }
```

## Usage

### Basic Initialization
```kotlin
val printer = SenraisePrinterHelper()
printer.init(this)

btn.setOnClickListener {
  printer.setAlign(CENTER_ALIGN)
  printer.printText("Hello World", 27f, false)
  printer.feedPaper(5)
}
```

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.
