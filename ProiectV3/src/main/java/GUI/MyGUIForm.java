package main.java.GUI;

import main.java.Threads.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyGUIForm extends JFrame{
    static JPanel rootPanel;
    static JButton b0,b1, b2, b3;

    public MyGUIForm(){

        JFrame f = new JFrame("Menu");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b0 = new JButton("Create a Page");
        b1 = new JButton("Delete one");
        b2 = new JButton("Find first");
        b3 = new JButton("DB Raw operations");


        b0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                createPageThread myThread1 = new createPageThread("createPageThread");
                myThread1.start();
            }
        } );
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                //          JOptionPane.showMessageDialog(rootPanel, "b2");
                JFrame fb3 = new JFrame("DeleteOne");
                fb3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JButton b4, b5, b6, b7, jButton1;

                b4 = new JButton("Note");
                b5 = new JButton("ToDo");
                b6 = new JButton("Remainder");
                b7 = new JButton("Tracker");
                jButton1 = new JButton("close");

                b4.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e1) {
                        noteDeleteFirstThread myThread1 = new noteDeleteFirstThread("noteDeleteFirstThread");
                        myThread1.start();
                    }
                });

                b5.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e1) {
                        todoDeleteFirstThread myThread1 = new todoDeleteFirstThread("todoDeleteFirstThread");
                        myThread1.start();
                    }
                });

                b6.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e1) {
                        remainderDeleteFirstThread myThread1 = new remainderDeleteFirstThread("remainderDeleteFirstThread");
                        myThread1.start();
                    }
                });


                b7.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e1) {
                        trackerDeleteFirstThread myThread1 = new trackerDeleteFirstThread("trackerDeleteFirstThread");
                        myThread1.start();
                    }
                });

                jButton1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        fb3.dispose();
                    }
                });

                b4.setBounds(130, 40, 140, 40);
                b5.setBounds(130, 100, 140, 40);
                b6.setBounds(130, 160, 140, 40);
                b7.setBounds(130, 220, 140, 40);
                jButton1.setBounds(130, 280, 140, 40);

                fb3.add(b4);
                fb3.add(b5);
                fb3.add(b6);
                fb3.add(b7);
                fb3.add(jButton1);

                fb3.setSize(400, 500);
                fb3.setLayout(null);
                fb3.setVisible(true);
            }
        } );

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e2) {
    //          JOptionPane.showMessageDialog(rootPanel, "b2");
                JFrame fb3 = new JFrame("FindOne");
                fb3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JButton b4, b5, b6, b7, jButton1;

                b4 = new JButton("Note");
                b5 = new JButton("ToDo");
                b6 = new JButton("Remainder");
                b7 = new JButton("Tracker");
                jButton1 = new JButton("close");

                b4.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e1) {
                        noteFindThread myThread1 = new noteFindThread("noteFindThread");
                        myThread1.start();
                    }
                });

                b5.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e1) {
                        todoFindThread myThread1 = new todoFindThread("todoFindThread");
                        myThread1.start();
                    }
                });

                b6.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e1) {
                        remainderFindThread myThread1 = new remainderFindThread("remainderFindThread");
                        myThread1.start();
                    }
                });


                b7.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e1) {
                        trackerFindThread myThread1 = new trackerFindThread("trackerFindThread");
                        myThread1.start();
                    }
                });

                jButton1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        fb3.dispose();
                    }
                });

                b4.setBounds(130,40,140, 40);
                b5.setBounds(130,100,140, 40);
                b6.setBounds(130,160,140, 40);
                b7.setBounds(130,220,140, 40);
                jButton1.setBounds(130,280,140, 40);

                fb3.add(b4);
                fb3.add(b5);
                fb3.add(b6);
                fb3.add(b7);
                fb3.add(jButton1);

                fb3.setSize(400,500);
                fb3.setLayout(null);
                fb3.setVisible(true);
            }
        } );

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e3) {
//                JOptionPane.showMessageDialog(rootPanel, "b3");
                JFrame fb3 = new JFrame("Raw DV Operations");
                fb3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JButton b4, b5, b6, b7, b77, jButton1;

                b4 = new JButton("Create");
                b5 = new JButton("Read");
                b6 = new JButton("Update");
                b7 = new JButton("Delete");
                b77 = new JButton("Recreate");
                jButton1 = new JButton("close");

                b4.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e1) {
                        JFrame fb4 = new JFrame("Create");
                        fb4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        JButton b8, b9, b10, b11, jButton1;

                        b8 = new JButton("Note");
                        b9 = new JButton("ToDo");
                        b10 = new JButton("Remainder");
                        b11 = new JButton("Tracker");
                        jButton1 = new JButton("close");

                        b8.addActionListener(new ActionListener() {
                             public void actionPerformed(ActionEvent e1) {
                                noteCreateThread myThread1 = new noteCreateThread("noteCreateThread");
                                myThread1.start();
                             }
                         });
                        b9.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e1) {
                                todoCreateThread myThread2 = new todoCreateThread("todoCreateThread");
                                myThread2.start();
                            }
                        });
                        b10.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e1) {
                                remainderCreateThread myThread3 = new remainderCreateThread("remainderCreateThread");
                                myThread3.start();
                            }
                        });
                        b11.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e1) {
                                trackerCreateThread myThread4 = new trackerCreateThread("trackerCreateThread");
                                myThread4.start();
                            }
                        });


                        jButton1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e)
                            {
                                fb4.dispose();
                            }
                        });

                        b8.setBounds(130,40,140, 40);
                        b9.setBounds(130,100,140, 40);
                        b10.setBounds(130,160,140, 40);
                        b11.setBounds(130,220,140, 40);
                        jButton1.setBounds(130,280,140, 40);

                        fb4.add(b8);
                        fb4.add(b9);
                        fb4.add(b10);
                        fb4.add(b11);
                        fb4.add(jButton1);

                        fb4.setSize(400,500);
                        fb4.setLayout(null);
                        fb4.setVisible(true);
                    }
                });

                b5.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e1) {
                        JFrame fb4 = new JFrame("Read");
                        fb4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        JButton b8, b9, b10, b11, jButton1;

                        b8 = new JButton("Note");
                        b9 = new JButton("ToDo");
                        b10 = new JButton("Remainder");
                        b11 = new JButton("Tracker");
                        jButton1 = new JButton("close");
                        b8.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e1) {
                                noteReadThread myThread1 = new noteReadThread("noteReadThread");
                                myThread1.start();
                            }
                        });
                        b9.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e1) {
                                todoReadThread myThread2 = new todoReadThread("todoReadThread");
                                myThread2.start();
                            }
                        });
                        b10.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e1) {
                                remainderReadThread myThread3 = new remainderReadThread("remainderReadThread");
                                myThread3.start();
                            }
                        });
                        b11.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e1) {
                                trackerReadThread myThread4 = new trackerReadThread("trackerReadThread");
                                myThread4.start();
                            }
                        });

                        jButton1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e)
                            {
                                fb4.dispose();
                            }
                        });

                        b8.setBounds(130,40,140, 40);
                        b9.setBounds(130,100,140, 40);
                        b10.setBounds(130,160,140, 40);
                        b11.setBounds(130,220,140, 40);
                        jButton1.setBounds(130,280,140, 40);

                        fb4.add(b8);
                        fb4.add(b9);
                        fb4.add(b10);
                        fb4.add(b11);
                        fb4.add(jButton1);

                        fb4.setSize(400,500);
                        fb4.setLayout(null);
                        fb4.setVisible(true);
                    }
                });

                b6.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e1) {
                        JFrame fb4 = new JFrame("Update");
                        fb4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        JButton b8, b9, b10, b11, jButton1;

                        b8 = new JButton("Note");
                        b9 = new JButton("ToDo");
                        b10 = new JButton("Remainder");
                        b11 = new JButton("Tracker");
                        jButton1 = new JButton("close");

                        b8.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e1) {
                                noteUpdateThread myThread1 = new noteUpdateThread("noteUpdateThread");
                                myThread1.start();
                            }
                        });
                        b9.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e1) {
                                todoUpdateThread myThread2 = new todoUpdateThread("todoUpdateThread");
                                myThread2.start();
                            }
                        });
                        b10.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e1) {
                                remainderUpdateThread myThread3 = new remainderUpdateThread("remainderUpdateThread");
                                myThread3.start();
                            }
                        });
                        b11.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e1) {
                                trackerUpdateThread myThread4 = new trackerUpdateThread("trackerUpdateThread");
                                myThread4.start();
                            }
                        });

                        jButton1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e)
                            {
                                fb4.dispose();
                            }
                        });

                        b8.setBounds(130,40,140, 40);
                        b9.setBounds(130,100,140, 40);
                        b10.setBounds(130,160,140, 40);
                        b11.setBounds(130,220,140, 40);
                        jButton1.setBounds(130,280,140, 40);

                        fb4.add(b8);
                        fb4.add(b9);
                        fb4.add(b10);
                        fb4.add(b11);
                        fb4.add(jButton1);

                        fb4.setSize(400,500);
                        fb4.setLayout(null);
                        fb4.setVisible(true);
                    }
                });


                b7.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e1) {
                        JFrame fb4 = new JFrame("Delete");
                        fb4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        JButton b8, b9, b10, b11, jButton1;

                        b8 = new JButton("Note");
                        b9 = new JButton("ToDo");
                        b10 = new JButton("Remainder");
                        b11 = new JButton("Tracker");
                        jButton1 = new JButton("close");

                        b8.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e1) {
                                noteDeleteThread myThread1 = new noteDeleteThread("noteDeleteThread");
                                myThread1.start();
                            }
                        });
                        b9.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e1) {
                                todoDeleteThread myThread2 = new todoDeleteThread("todoDeleteThread");
                                myThread2.start();
                            }
                        });
                        b10.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e1) {
                                remainderDeleteThread myThread3 = new remainderDeleteThread("remainderDeleteThread");
                                myThread3.start();
                            }
                        });
                        b11.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e1) {
                                trackerDeleteThread myThread4 = new trackerDeleteThread("trackerDeleteThread");
                                myThread4.start();
                            }
                        });

                        jButton1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e)
                            {
                                fb4.dispose();
                            }
                        });

                        b8.setBounds(130,40,140, 40);
                        b9.setBounds(130,100,140, 40);
                        b10.setBounds(130,160,140, 40);
                        b11.setBounds(130,220,140, 40);
                        jButton1.setBounds(130,280,140, 40);

                        fb4.add(b8);
                        fb4.add(b9);
                        fb4.add(b10);
                        fb4.add(b11);
                        fb4.add(jButton1);

                        fb4.setSize(400,500);
                        fb4.setLayout(null);
                        fb4.setVisible(true);
                    }
                });


                b77.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e1) {
                        JFrame fb4 = new JFrame("RebuildBD");
                        fb4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        JButton b8, b9, b10, b11, jButton1;

                        b8 = new JButton("Note");
                        b9 = new JButton("ToDo");
                        b10 = new JButton("Remainder");
                        b11 = new JButton("Tracker");
                        jButton1 = new JButton("close");

                        b8.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e1) {
                                noteRecThread myThread1 = new noteRecThread("noteRecThread");
                                myThread1.start();
                            }
                        });
                        b9.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e1) {
                                todoRecThread myThread2 = new todoRecThread("todoRecThread");
                                myThread2.start();
                            }
                        });
                        b10.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e1) {
                                remainderRecThread myThread3 = new remainderRecThread("remainderRecThread");
                                myThread3.start();
                            }
                        });
                        b11.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e1) {
                                trackerRecThread myThread4 = new trackerRecThread("trackerRecThread");
                                myThread4.start();
                            }
                        });


                        jButton1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e)
                            {
                                fb4.dispose();
                            }
                        });

                        b8.setBounds(130,40,140, 40);
                        b9.setBounds(130,100,140, 40);
                        b10.setBounds(130,160,140, 40);
                        b11.setBounds(130,220,140, 40);
                        jButton1.setBounds(130,280,140, 40);

                        fb4.add(b8);
                        fb4.add(b9);
                        fb4.add(b10);
                        fb4.add(b11);
                        fb4.add(jButton1);

                        fb4.setSize(400,500);
                        fb4.setLayout(null);
                        fb4.setVisible(true);
                    }
                });

                jButton1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        fb3.dispose();
                    }
                });

                b4.setBounds(130,40,140, 40);
                b5.setBounds(130,100,140, 40);
                b6.setBounds(130,160,140, 40);
                b7.setBounds(130,220,140, 40);
                b77.setBounds(130,280,140, 40);
                jButton1.setBounds(130,340,140, 40);

                fb3.add(b4);
                fb3.add(b5);
                fb3.add(b6);
                fb3.add(b7);
                fb3.add(b77);
                fb3.add(jButton1);

                fb3.setSize(400,500);
                fb3.setLayout(null);
                fb3.setVisible(true);
            }
        } );


        b0.setBounds(130,40,160, 40);
        b1.setBounds(130,100,160, 40);
        b2.setBounds(130,160,160, 40);
        b3.setBounds(130,220,160, 40);

        f.add(b0);
        f.add(b1);
        f.add(b2);
        f.add(b3);

        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
    }
}