// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/recipes.proto

package service;

public final class RecipeProto {
  private RecipeProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_RecipeReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_RecipeReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_RecipeRateReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_RecipeRateReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_RecipeResp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_RecipeResp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_RecipeViewResp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_RecipeViewResp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_Ingredient_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_Ingredient_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_RecipeEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_RecipeEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026services/recipes.proto\022\010services\032\033goog" +
      "le/protobuf/empty.proto\"S\n\tRecipeReq\022\014\n\004" +
      "name\030\001 \001(\t\022\016\n\006author\030\002 \001(\t\022(\n\ningredient" +
      "\030\003 \003(\0132\024.services.Ingredient\"+\n\rRecipeRa" +
      "teReq\022\n\n\002id\030\001 \001(\005\022\016\n\006rating\030\002 \001(\002\"?\n\nRec" +
      "ipeResp\022\021\n\tisSuccess\030\001 \001(\010\022\017\n\007message\030\002 " +
      "\001(\t\022\r\n\005error\030\003 \001(\t\"Z\n\016RecipeViewResp\022\021\n\t" +
      "isSuccess\030\001 \001(\010\022&\n\007recipes\030\002 \003(\0132\025.servi" +
      "ces.RecipeEntry\022\r\n\005error\030\003 \001(\t\"=\n\nIngred" +
      "ient\022\014\n\004name\030\001 \001(\t\022\020\n\010quantity\030\002 \001(\005\022\017\n\007" +
      "details\030\003 \001(\t\"q\n\013RecipeEntry\022\n\n\002id\030\001 \001(\005" +
      "\022\014\n\004name\030\002 \001(\t\022(\n\ningredient\030\003 \003(\0132\024.ser" +
      "vices.Ingredient\022\016\n\006author\030\004 \001(\t\022\016\n\006rati" +
      "ng\030\005 \001(\0022\304\001\n\006Recipe\0228\n\taddRecipe\022\023.servi" +
      "ces.RecipeReq\032\024.services.RecipeResp\"\000\022A\n" +
      "\013viewRecipes\022\026.google.protobuf.Empty\032\030.s" +
      "ervices.RecipeViewResp\"\000\022=\n\nrateRecipe\022\027" +
      ".services.RecipeRateReq\032\024.services.Recip" +
      "eResp\"\000B\030\n\007serviceB\013RecipeProtoP\001b\006proto" +
      "3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.EmptyProto.getDescriptor(),
        });
    internal_static_services_RecipeReq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_services_RecipeReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_RecipeReq_descriptor,
        new java.lang.String[] { "Name", "Author", "Ingredient", });
    internal_static_services_RecipeRateReq_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_services_RecipeRateReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_RecipeRateReq_descriptor,
        new java.lang.String[] { "Id", "Rating", });
    internal_static_services_RecipeResp_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_services_RecipeResp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_RecipeResp_descriptor,
        new java.lang.String[] { "IsSuccess", "Message", "Error", });
    internal_static_services_RecipeViewResp_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_services_RecipeViewResp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_RecipeViewResp_descriptor,
        new java.lang.String[] { "IsSuccess", "Recipes", "Error", });
    internal_static_services_Ingredient_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_services_Ingredient_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_Ingredient_descriptor,
        new java.lang.String[] { "Name", "Quantity", "Details", });
    internal_static_services_RecipeEntry_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_services_RecipeEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_RecipeEntry_descriptor,
        new java.lang.String[] { "Id", "Name", "Ingredient", "Author", "Rating", });
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}