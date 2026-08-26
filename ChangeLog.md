# Changelog

## 2.0.0

### 日本語

Aoyama's NoCaves+more を大幅に再構築しました。

以前のバージョンのデータはロストバゲッジしてしまいました。ごめんね。

そのため、2.0.0では実質的に新しく作り直す形で、構成や処理を見直しています。

### 主な変更

- MODを大幅に再構築
- 各種ワールド生成制御をConfigから個別に設定可能に変更
- オーバーワールドの洞窟生成を無効化する機能を実装
- 峡谷（Ravine）の生成を無効化する機能を実装
- 地下の水湖を無効化する機能を実装
- 地表の水湖は維持
- 地下の溶岩湖を無効化する機能を実装
- 地表の溶岩湖は維持
- オーバーワールドのLava Springsを無効化する機能を実装
- ネザー洞窟の生成を無効化する機能を追加
- ネザーのLava Springsを無効化する機能を追加
- ネザーラック内部のLava Pocketsを無効化する機能を追加
- ネザーの溶岩海には影響しないように調整
- ゲーム内Config画面から各機能のON/OFFを変更可能
- The Lost Citiesとの互換性を確認
- Worley's Cavesのような洞窟生成置換MODとの互換性を改善
- Nomifactory CEu 1.7.7環境で動作確認

### 注意

このMODはワールド生成時に処理を行うため、既に生成済みのチャンクには反映されません。

設定変更後の確認は、新規ワールドまたは未生成チャンクで行ってください。

---

### English

Aoyama's NoCaves+more has been significantly rebuilt.

Unfortunately, the data from the previous versions was lost in transit. Sorry about that.

Because of this, version 2.0.0 was effectively rebuilt from scratch, with the structure and world generation handling redesigned.

### Main Changes

- Significantly rebuilt the mod
- Added individual configuration options for world generation features
- Added configurable Overworld cave removal
- Added ravine removal
- Added underground water lake removal
- Surface water lakes are preserved
- Added underground lava lake removal
- Surface lava lakes are preserved
- Added Overworld Lava Spring removal
- Added optional Nether cave removal
- Added Nether Lava Spring removal
- Added hidden Nether Lava Pocket removal
- The Nether lava ocean is preserved
- Added in-game configuration support
- Confirmed compatibility with The Lost Cities
- Improved compatibility with cave generator replacement mods such as Worley's Caves
- Tested with Nomifactory CEu 1.7.7

### Important

This mod affects world generation only.

Already generated chunks are not modified.

When testing configuration changes, use a new world or generate new chunks.
