/*
 * Copyright (c) 2017. Louis Cognault Ayeva Derman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package splitties.material.lists

import android.content.Context
import android.support.v7.widget.SwitchCompat
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import xyz.louiscad.selectableviewgroups.widget.SelectableConstraintLayout

@Deprecated(
        message = "Use IconTwoLinesSwitchListItem instead. It is more efficient and " +
                "fixes bugs on long first lines",
        replaceWith = ReplaceWith(
                expression = "IconTwoLinesSwitchListItem",
                imports = ["splitties.material.lists.IconTwoLinesSwitchListItem"]
        )
)
class TwoLinesIconSwitchListItem @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : SelectableConstraintLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.content_list_item_two_lines_icon_switch, this)
    }

    val icon: ImageView = findViewById(R.id.icon)
    val firstLine: TextView = findViewById(R.id.firstLine)
    val secondLine: TextView = findViewById(R.id.secondLine)
    val toggle: SwitchCompat = findViewById(R.id.toggle)
}
