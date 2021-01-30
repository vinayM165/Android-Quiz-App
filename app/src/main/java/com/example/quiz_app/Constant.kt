package com.example.quiz_app

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.stream.IntStream.range

object Constant {
    const val CORRECT_ANSWER_COUNT = "com.cebrailyilmaz.quizapp.CORRECT_ANSWER_COUNT"
    const val TOTAL_QUESTION_COUNT = "com.cebrailyilmaz.quizapp.TOTAL_QUESTION_COUNT"
//    val resultHistory: ArrayList<Result> = ArrayList()

    @RequiresApi(Build.VERSION_CODES.N)
    fun getQuestions(): List<Question> {
        val questionList = ArrayList<Question>()

        val q1 = Question(1,
                "What is the capital of India?",
                "Delhi",
                "Mumbai",
                "Pune",
                "Surat",
                1
        )

        val q2 = Question(2,
                "Who is Prime Minister of India?",
                "Sharad Pawar",
                "Rahul Gandhi",
                "Joe Biden",
                "Narendra Modi",
                4
        )

        val q3 = Question(3,
                "Which country has highest population in the world?",
                "China",
                "Turkey",
                "USA",
                "France",
                1
        )

        val q4 = Question(4,
                "Who founded Facebook?",
                "Elon Musk",
                "Mark Zukerberg",
                "Larry Page",
                "Andrew Flintoff",
                2
        )

        val q5 = Question(5,
                "Who owns the brand Tata company pvt. Ltd.?",
                "Mukesh Ambani",
                "Gautam Adani",
                "Ratan Tata",
                "Brazil",
                3
        )
        val q6 = Question(6,
                "1024 kilobytes is equal to _?",
                "1 Megabyte(MB)",
                "1 Gigabyte (GB)",
                "1 TetaByte (TB)",
                "10 Kilobyte (KB)",
                1
        )

        val q7 = Question(7,
                "Who is Paulo Coelho?",
                "Painter",
                "Architect",
                "Politician",
                "Brazilian Novelist",
                4
        )

        val q8 = Question(8,
                "A figure with 6 sides is known as ________?",
                "Hexagon",
                "Pentagon",
                "Septagon",
                "Cube",
                1
        )

        val q9 = Question(9,
                "What do UPS stand for?",
                "Universal Passport System",
                "Uninterrupted Power Supply",
                "Unified Protocol System",
                "Unidentified Passing Structure",
                2
        )

        val q10 = Question(10,
                "At which temperature does water boil?",
                "10◦C",
                "50◦C",
                "100◦C",
                "100◦F",
                3
        )
        val q11 = Question(11,
                "Name the acid in lemon.",
                "Citric acid",
                "Acetic Acid",
                "Boric Acid",
                "Nitric Acid",
                1
        )

        val q12 = Question(12,
                "Which is the first animal to land on the moon?",
                "Donald - The duck",
                "danny- The Zebra",
                "Joe, The Monkey",
                "Laika, The dog",
                4
        )

        val q13 = Question(13,
                "Statue of Liberty is in _.",
                "China",
                "Turkey",
                "USA",
                "France",
                3
        )

        val q14 = Question(14,
                "What is the full form of  HTTP?",
                "Hypertext Markup Language",
                "Hypertext Transfer Protocol",
                "Hypertext Topology Protocol",
                "Hyper Transfer Text Protocol",
                2
        )

        val q15 = Question(15,
                "Which gas is known as “Laughing gas?",
                "Benzene",
                "Sodium Chloride",
                "Nitrous Oxide",
                "Carbon Dioxide",
                3
        )

        questionList.add(q1)
        questionList.add(q2)
        questionList.add(q3)
        questionList.add(q4)
        questionList.add(q5)
        questionList.add(q6)
        questionList.add(q7)
        questionList.add(q8)
        questionList.add(q9)
        questionList.add(q10)
        questionList.add(q11)
        questionList.add(q12)
        questionList.add(q13)
        questionList.add(q14)
        questionList.add(q15)

        questionList.shuffle()
        val newarr = ArrayList<Question>()
        for (i in 0..4){
            newarr.add(questionList[i])
        }
        return newarr
    }
}
