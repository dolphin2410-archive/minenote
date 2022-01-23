package io.github.dolphin2410.minenote.minecraft

import io.github.dolphin2410.minenote.MineNotePlugin
import io.github.dolphin2410.minenote.sheet.SampleSheet
import io.github.dolphin2410.minenote.sheet.SampleSheet2
import io.github.monun.kommand.kommand

object CommandHandler {

    @JvmStatic
    fun register() {
        MineNotePlugin.plugin.kommand {
            register("minenote") {
                then("sample") {
                    executes {
                        val sheet = SampleSheet.create()
                        val converter = SheetConverter(player, sheet)
                        converter.convert()
                    }
                }

                then("sample2") {
                    executes {
                        val sheet = SampleSheet2.create()
                        val converter = SheetConverter(player, sheet)
                        converter.convert()
                    }
                }
            }
        }
    }
}