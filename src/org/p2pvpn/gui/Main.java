/*
    Copyright 2008 Wolfgang Ginolas

    This file is part of P2PVPN.

    P2PVPN is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Foobar is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
*/

/*
 * Main.java
 *
 * Created on 29. Oktober 2008, 11:43
 */

package org.p2pvpn.gui;

import java.util.Map;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.p2pvpn.network.PeerID;
import org.p2pvpn.network.ConnectionManager;
import org.p2pvpn.network.Router;
import org.p2pvpn.network.RoutungTableListener;

/**
 *
 * @author  wolfgang
 */
public class Main extends javax.swing.JFrame implements RoutungTableListener {
	private static final long serialVersionUID = -7583281386025886297L;
	
	private ConnectionManager connectionManager;
	private PeerID addrShown = null;
	
	/** Creates new form Main */
    public Main(ConnectionManager cm) {
        this.connectionManager = cm;
		connectionManager.getRouter().addTableListener(this);
    	setLocationByPlatform(true);
    	
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initComponents();
				peerTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						for(int i=e.getFirstIndex(); i<=e.getLastIndex(); i++) {
							if (peerTable1.getSelectionModel().isSelectedIndex(i)) {
								peerSelected(i);
								break;
							}
						}
					}
				});
            	setLocalInfo(
            			"ID: "+connectionManager.getLocalAddr()+
            			"  Port: "+connectionManager.getServerPort());
            	setVisible(true);
            }
        });
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        quitBtn = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        peerInfo = new javax.swing.JTextArea();
        aPanel1 = new javax.swing.JPanel();
        connectBtn1 = new javax.swing.JButton();
        hostConnectText1 = new javax.swing.JTextField();
        localInfo1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        peerTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("P2PVPN Test");

        quitBtn.setText("Quit");
        quitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventQuit(evt);
            }
        });

        jSplitPane1.setDividerLocation(250);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setContinuousLayout(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Info"));

        peerInfo.setColumns(20);
        peerInfo.setEditable(false);
        peerInfo.setRows(5);
        peerInfo.setText(" ");
        jScrollPane3.setViewportView(peerInfo);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(jPanel2);

        aPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Connections"));

        connectBtn1.setText("Connect To");
        connectBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventConnectTo(evt);
            }
        });

        hostConnectText1.setToolTipText("host:port");

        localInfo1.setText(" ");

        peerTable1.setModel(new PeerTableModel(connectionManager));
        peerTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(peerTable1);

        javax.swing.GroupLayout aPanel1Layout = new javax.swing.GroupLayout(aPanel1);
        aPanel1.setLayout(aPanel1Layout);
        aPanel1Layout.setHorizontalGroup(
            aPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aPanel1Layout.createSequentialGroup()
                .addGroup(aPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(localInfo1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
                    .addGroup(aPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(connectBtn1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hostConnectText1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
                    .addGroup(aPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)))
                .addContainerGap())
        );
        aPanel1Layout.setVerticalGroup(
            aPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aPanel1Layout.createSequentialGroup()
                .addComponent(localInfo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hostConnectText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connectBtn1))
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(aPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE))
                    .addComponent(quitBtn))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quitBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void eventQuit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventQuit
		System.exit(0);
	}//GEN-LAST:event_eventQuit

private void eventConnectTo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventConnectTo
	connectionManager.connectTo(hostConnectText1.getText());
}//GEN-LAST:event_eventConnectTo

	private void peerSelected(int i) {
		if (i<0) {
			return;
		}
		
		addrShown = ((PeerTableModel)peerTable1.getModel()).getPeerID(i);
		tableChanged(null);
	}	

	public void setLocalInfo(String s) {
		localInfo1.setText(s);
	}
	
    public static void open(ConnectionManager cm) {
    	new Main(cm);
    }

	public void tableChanged(Router router) {
		StringBuffer info = new StringBuffer();
		info.append("Info for "+addrShown+"\n\n");
		Map<String, String> map = connectionManager.getRouter().getPeerInfo(addrShown);
		if (map==null) {
			peerInfo.setText("");
			return;
		}
		
		for(Map.Entry<String, String> e : map.entrySet()) {
			info.append(e.getKey()+"="+e.getValue()+"\n");
		}
		
		peerInfo.setText(info.toString());
	}
	
	// TODO remove & rename variables
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aPanel1;
    private javax.swing.JButton connectBtn1;
    private javax.swing.JTextField hostConnectText1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel localInfo1;
    private javax.swing.JTextArea peerInfo;
    private javax.swing.JTable peerTable1;
    private javax.swing.JButton quitBtn;
    // End of variables declaration//GEN-END:variables

    
}
