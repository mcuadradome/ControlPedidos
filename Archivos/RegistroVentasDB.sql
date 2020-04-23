USE [REGISTROVENTAS]
GO
/****** Object:  Table [dbo].[CARGUE_INVENTARIO]    Script Date: 23/04/2020 6:48:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CARGUE_INVENTARIO](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_vendedor_fk] [int] NOT NULL,
	[id_zona_fk] [varchar](10) NOT NULL,
	[fecha] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_CARGUE_INVENTARIO] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CLIENTE]    Script Date: 23/04/2020 6:48:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CLIENTE](
	[id_cliente] [int] IDENTITY(1,1) NOT NULL,
	[identificacion] [nvarchar](50) NULL,
	[nombre_cliente] [nvarchar](50) NULL,
	[telefono] [nvarchar](50) NULL,
	[direccion] [nvarchar](50) NULL,
 CONSTRAINT [PK_CLIENTE] PRIMARY KEY CLUSTERED 
(
	[id_cliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[INVENTARIO]    Script Date: 23/04/2020 6:48:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[INVENTARIO](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[cantidad] [int] NOT NULL,
	[id_producto_fk] [nvarchar](50) NOT NULL,
	[id_cargue_inventario_fk] [int] NOT NULL,
 CONSTRAINT [PK_INVENTARIO] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ORDEN_VENTA]    Script Date: 23/04/2020 6:48:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ORDEN_VENTA](
	[id_orden] [int] IDENTITY(1,1) NOT NULL,
	[id_venta] [int] NULL,
	[id_producto_fk] [nvarchar](50) NOT NULL,
	[cantidad] [int] NULL,
	[total_producto] [int] NULL,
	[precio_producto] [int] NULL,
	[por_paquete] [bit] NULL,
 CONSTRAINT [PK_ORDEN_VENTA] PRIMARY KEY CLUSTERED 
(
	[id_orden] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PRODUCTOS]    Script Date: 23/04/2020 6:48:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PRODUCTOS](
	[id] [nvarchar](50) NOT NULL,
	[nombre] [nvarchar](50) NULL,
	[iva] [int] NULL,
	[precio] [int] NULL,
	[embalaje] [int] NULL,
 CONSTRAINT [PK_PRODUCTOS] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[USUARIO]    Script Date: 23/04/2020 6:48:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[USUARIO](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nvarchar](50) NOT NULL,
	[identificacion] [nvarchar](50) NOT NULL,
	[telefono] [nvarchar](50) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_USUARIO] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[USUARIO_LOGUEADO]    Script Date: 23/04/2020 6:48:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[USUARIO_LOGUEADO](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_usuario_fk] [int] NOT NULL,
	[rol] [nchar](10) NOT NULL,
	[usuario] [nchar](10) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_USUARIO_LOGUEADO] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VENDEDOR]    Script Date: 23/04/2020 6:48:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VENDEDOR](
	[id] [int] NOT NULL,
	[nombre] [nvarchar](50) NULL,
	[telefono] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
	[estado] [bit] NULL,
 CONSTRAINT [PK_VENDEDOR] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VENTA]    Script Date: 23/04/2020 6:48:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VENTA](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[cliente_fk] [int] NULL,
	[fecha] [nvarchar](50) NOT NULL,
	[vendedor_fk] [int] NULL,
	[id_zona_fk] [varchar](10) NULL,
 CONSTRAINT [PK_VENTA] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ZONA]    Script Date: 23/04/2020 6:48:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ZONA](
	[id] [varchar](10) NOT NULL,
	[nombre] [varchar](10) NOT NULL,
	[id_vendedor_fk] [int] NOT NULL,
	[id_zona_fk] [varchar](10) NULL,
 CONSTRAINT [PK_ZONA] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10022', N'PAPA SUPER CROKANTE 40GR', 988, 6, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10039', N'DELIMANI CON SAL X 25GR', 402, 12, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10067', N'SUPER CHEESE 48GR', 700, 8, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10081', N'TAJAMIEL 40GR', 830, 12, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10083', N'TAJADITAS 40GR', 830, 12, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10087', N'PAPA SUPER CROKANTE GALLINA 40GR', 988, 6, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10089', N'PAPA SUPER CROKANTE CERDO 40GR', 988, 6, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10122', N'PAPA SUPER CROKANTE GALLINA 115GR', 2185, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10123', N'PAPA SUPER CROKANTE CERDO 115GR', 2185, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10128', N'PAPA ONDITAS MEGA LIMON 32.5GR', 938, 12, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10131', N'CHIRRICO LIMON X 45GR', 797, 35, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10132', N'PAPA ONDITAS LIMON X 115GR', 2101, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10133', N'TODORICO LIMON X 45GR', 1155, 8, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10138', N'PAPA SUPER PAKETE POLLO X 45GR', 1070, 6, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10158', N'PAPA POLLO X 30GR', 938, 12, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10159', N'PAPA NATURAL X 30GR', 938, 12, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10160', N'PAPA PIKANTE X 30GR', 938, 12, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10161', N'PAPA BAR-B-Q X 30GR', 938, 12, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10162', N'PAPA LIMON X 30GR', 938, 12, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10229', N'SUPER SURTIDA PRACTICA', 3900, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10268', N'TODORICO CRIOLLO AJI 55GR', 1250, 8, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'103', N'FOSFORO GRANDE', 2353, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10432', N'TROCITO POLLO 120GR', 1470, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10594', N'CHIRRICOS MAXI QUESO 28GR', 630, 8, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10623', N'PAPA GOURMET SALSA ARRABIATA 40GR', 989, 6, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10625', N'PAPA GOURMET SALSA ARRABIATA 115GR', 2185, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10627', N'PAPA GOURMET SALSA VINAGRETA 40GR', 989, 6, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10629', N'PAPA GOURMET SALSA VINAGRETA 115GR', 2185, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10644', N'SUPER SURTIDA FANATICA', 4800, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10647', N'TODO RICO CRIOLLO AJI 180GR', 3359, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10648', N'TODORICO BQQ 250GR', 3824, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10707', N'TODORICO CRIOLLO CALENTADO', 1250, 8, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'10713', N'CHICARRON BBQ X 10GR', 665, 12, 5)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'161', N'DELIMANI X 50GR', 860, 12, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'182', N'FOSFORO  X 35GR', 745, 12, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'193', N'TODORICO CRIOLLO X 55GR', 1250, 8, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'201', N'PAPA NATURAL 25GR', 7152, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'205', N'NATURAL SUPERGIGANTE X 350GR', 4901, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'222', N'PAPA NATURAL 115GR', 2101, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'223', N'PAPA POLLO 115GR', 2101, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'224', N'PAPA PICANTE 115 GR ', 2101, 1, 119)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'225', N'PAPA NATURAL 215GR', 3179, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'226', N'PAPA POLLO 215GR', 3179, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'301', N'PAPA POLLO 25GR', 7152, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'305', N'POLLO SUPERGIGANTE 350GR', 4901, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'350', N'TODORICO CRIOLLO 180GR', 3350, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'396', N'MANI CON PASAS X 50GR', 950, 12, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'401', N'PAPA PICANTE 25GR', 7152, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'447', N'CHIRRICO CARAMELO X 50GR', 797, 25, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'475', N'DISPLAY DELIMANI X 50GR', 15998, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'511', N'PAPA BQQ 25GR', 7152, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'532', N'PAPA LIMON 25GR', 7152, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'640', N'PAPA SUPER CROKANTE 115GR', 2095, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'703', N'CHICHARRON GRANDE 50GR', 2095, 1, 5)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'744', N'TODORICO BBQ X6 - 45GR', 6930, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'757', N'CHICHARRON X 10GR', 665, 24, 5)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'760', N'TODORICO NAT X6 - 45GR', 6930, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'783', N'TODORICO NAT', 8085, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'784', N'TODORICO BQQ', 8085, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'792', N'TODORICO BBQ 160GR', 2604, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'814', N'TROCITOS POLLO X 32GR', 420, 12, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'815', N'RIQUILLAS X 15GR', 643, 12, 5)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'823', N'CHIRRICO NATURAL X 55GR', 730, 40, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'828', N'CHIRRICO X 10GR', 200, 12, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'833', N'TOCINETA X 12GR', 420, 8, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'855', N'CHIRRICO PIKANTICO 50GR', 730, 40, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'895', N'TODORICO NATURAL 45GR X 8', 1155, 8, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'896', N'TODORICO BBQ 45GR X8', 1155, 8, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'905', N'TODORICO NATURAL 160GR', 2634, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'911', N'PAPA NATURAL LIBRA', 6710, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'919', N'TODORICO NATURAL SUPERGIGANTE 250GR', 3824, 1, 19)
INSERT [dbo].[PRODUCTOS] ([id], [nombre], [iva], [precio], [embalaje]) VALUES (N'932', N'MIGA DE PAPA 1KL', 7155, 1, 19)
ALTER TABLE [dbo].[CARGUE_INVENTARIO]  WITH CHECK ADD  CONSTRAINT [FK_CARGUE_INVENTARIO_VENDEDOR] FOREIGN KEY([id_vendedor_fk])
REFERENCES [dbo].[VENDEDOR] ([id])
GO
ALTER TABLE [dbo].[CARGUE_INVENTARIO] CHECK CONSTRAINT [FK_CARGUE_INVENTARIO_VENDEDOR]
GO
ALTER TABLE [dbo].[CARGUE_INVENTARIO]  WITH CHECK ADD  CONSTRAINT [FK_CARGUE_INVENTARIO_ZONA] FOREIGN KEY([id_zona_fk])
REFERENCES [dbo].[ZONA] ([id])
GO
ALTER TABLE [dbo].[CARGUE_INVENTARIO] CHECK CONSTRAINT [FK_CARGUE_INVENTARIO_ZONA]
GO
ALTER TABLE [dbo].[INVENTARIO]  WITH CHECK ADD  CONSTRAINT [FK_INVENTARIO_CARGUE_INVENTARIO] FOREIGN KEY([id_cargue_inventario_fk])
REFERENCES [dbo].[CARGUE_INVENTARIO] ([id])
GO
ALTER TABLE [dbo].[INVENTARIO] CHECK CONSTRAINT [FK_INVENTARIO_CARGUE_INVENTARIO]
GO
ALTER TABLE [dbo].[INVENTARIO]  WITH CHECK ADD  CONSTRAINT [FK_INVENTARIO_PRODUCTOS] FOREIGN KEY([id_producto_fk])
REFERENCES [dbo].[PRODUCTOS] ([id])
GO
ALTER TABLE [dbo].[INVENTARIO] CHECK CONSTRAINT [FK_INVENTARIO_PRODUCTOS]
GO
ALTER TABLE [dbo].[ORDEN_VENTA]  WITH CHECK ADD  CONSTRAINT [FK_ORDEN_VENTA_PRODUCTOS] FOREIGN KEY([id_producto_fk])
REFERENCES [dbo].[PRODUCTOS] ([id])
GO
ALTER TABLE [dbo].[ORDEN_VENTA] CHECK CONSTRAINT [FK_ORDEN_VENTA_PRODUCTOS]
GO
ALTER TABLE [dbo].[ORDEN_VENTA]  WITH CHECK ADD  CONSTRAINT [FK_ORDEN_VENTA_VENTA] FOREIGN KEY([id_venta])
REFERENCES [dbo].[VENTA] ([id])
GO
ALTER TABLE [dbo].[ORDEN_VENTA] CHECK CONSTRAINT [FK_ORDEN_VENTA_VENTA]
GO
ALTER TABLE [dbo].[USUARIO_LOGUEADO]  WITH CHECK ADD  CONSTRAINT [FK_USUARIO_LOGUEADO_USUARIO] FOREIGN KEY([id_usuario_fk])
REFERENCES [dbo].[USUARIO] ([id])
GO
ALTER TABLE [dbo].[USUARIO_LOGUEADO] CHECK CONSTRAINT [FK_USUARIO_LOGUEADO_USUARIO]
GO
ALTER TABLE [dbo].[VENTA]  WITH CHECK ADD  CONSTRAINT [FK_VENTA_CLIENTE] FOREIGN KEY([cliente_fk])
REFERENCES [dbo].[CLIENTE] ([id_cliente])
GO
ALTER TABLE [dbo].[VENTA] CHECK CONSTRAINT [FK_VENTA_CLIENTE]
GO
ALTER TABLE [dbo].[VENTA]  WITH CHECK ADD  CONSTRAINT [FK_VENTA_VENDEDOR] FOREIGN KEY([vendedor_fk])
REFERENCES [dbo].[VENDEDOR] ([id])
GO
ALTER TABLE [dbo].[VENTA] CHECK CONSTRAINT [FK_VENTA_VENDEDOR]
GO
ALTER TABLE [dbo].[VENTA]  WITH CHECK ADD  CONSTRAINT [FK_VENTA_ZONA] FOREIGN KEY([id_zona_fk])
REFERENCES [dbo].[ZONA] ([id])
GO
ALTER TABLE [dbo].[VENTA] CHECK CONSTRAINT [FK_VENTA_ZONA]
GO
